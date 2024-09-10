package dao;

import pojos.Department;
import pojos.Employee;
import pojos.EmploymentType;

import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String saveEmpDetails(Employee emp, Long deptId) {

		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		System.out.println("session open " + session.isOpen() + " is connected " + session.isConnected());// t t
		// L1 cache is created.
		try {
			// 3. get dept from it's id
			Department dept = session.get(Department.class, deptId);
			//null chking
			if(dept != null)
			{
				//dept : PERSISTENT
				//establish bi dir asso bet entities : by calling helper method
				dept.addEmployee(emp);
				session.persist(emp);
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();// no auto dirty checking --- session is auto closed =>
			// L1 cache is destroyed n pooled out db cn rets to the pool
			// re throw the exc to the caller
			throw e;
		}
		return "Emp details added , with ID " + emp.getId();
	}

}
