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
		// L1 cache is created.
		try {
			// 3. get dept from it's id
			Department dept = session.get(Department.class, deptId);
			// null chking
			if (dept != null) {
				// dept : PERSISTENT
				// establish bi dir asso bet entities : by calling helper method
				dept.addEmployee(emp);// modifying the state of perssitent entity

				// session.persist(emp); not required in case of cascading !
			}
			tx.commit();// flush --> dirty chking --> new entity with cascade --> insert ...
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();// no auto dirty checking --- session is auto closed =>
			// L1 cache is destroyed n pooled out db cn rets to the pool
			// re throw the exc to the caller
			throw e;
		}
		return "Emp details added , with ID " + emp.getId();
	}

	@Override
	public String removeEmpFromDept(String deptName, String email1) {
		String mesg = "Removing emp failed....";
		String deptJpql = "select d from Department d where d.name=:nm";
		String empJpql = "select e from Employee e where e.email=:em";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();

		try {
			Department dept = session.createQuery(deptJpql, Department.class).setParameter("nm", deptName)
					.getSingleResult();
			// => dept : PERSISTENT
			Employee emp = session.createQuery(empJpql, Employee.class).setParameter("em", email1).getSingleResult();
			// emp : PERSISTENT
			dept.removeEmployee(emp);
			tx.commit();// flush --> dirty chking
			mesg = "Deleted emp details from dept " + deptName;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
