package dao;

import pojos.Employee;
import pojos.EmploymentType;

import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String saveEmpDetails(Employee emp) {
		// emp : TRANSIENT (exists ONLY in java heap!)
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		System.out.println("session open " + session.isOpen() + " is connected " + session.isConnected());// t t
		// L1 cache is created.
		try {
			session.persist(emp);// emp : PERSISTENT (exists in L1 cache) BUT not yet part of DB

			tx.commit();// session is auto closed =>
			// 1. session.flush() -->2. hib performs auto dirty checking
			// compares L1 cache with DB state : hib fires insert query
//to sync up state of DB with L1 cache
			// 3. L1 cache is destroyed n pooled out db cn rets to
			// the pool n then session is closed.
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();// no auto dirty checking --- session is auto closed =>
			// L1 cache is destroyed n pooled out db cn rets to the pool
			// re throw the exc to the caller
			throw e;
		}

		// emp : DETACHED (from L1 cache)
		return "Emp details added , with ID " + emp.getEmpId();
	}

	@Override
	public Employee getEmpDetailsById(long empId) {
		Employee emp = null;// state : DOES NOT exist
		// 1. Get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		try {
			// get emp details
			emp = session.get(Employee.class, empId);// select
			emp = session.get(Employee.class, empId);// rets from cache
			emp = session.get(Employee.class, empId);// rets from cache
			// in case of valid id , emp : PERSISTENT(part of L1 cache , part of DB)
			// invalid id : emp : null
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return emp;// emp : DETACHED
	}

	@Override
	public List<Employee> getAllEmps() {
		List<Employee> emps = null;
		String jpql = "select e from Employee e";
		// 1. Get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		try {
			// get list of emps
			emps = session.createQuery(jpql, Employee.class) // Query<Emp>
					.getResultList();
			// emps : list of PERSISTENT entities.
//			emps=session.createQuery(jpql, Employee.class) //Query<Emp>
//					.getResultList();
//		
//			emps=session.createQuery(jpql, Employee.class) //Query<Emp>
//					.getResultList();
//		
			tx.commit();// session.flush ---> auto dirty chking --> select : same state : NO DMLs --> l1
						// cache
						// destroyed , db cn rets to the pool ,session closed
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return emps;// list of DETACHED
	}

	@Override
	public List<Employee> getSelectedEmps(LocalDate begin, LocalDate end, double minSal) {
		List<Employee> emps = null;
		String jpql = "select e from Employee e where e.joinDate between :begin_dt and :end_dt and e.salary > :min";
		// 1. Get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		try {
			emps = session.createQuery(jpql, Employee.class).setParameter("begin_dt", begin).setParameter("end_dt", end)
					.setParameter("min", minSal).getResultList();
			// emps : list of PERSISTENT entities

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return emps;// emps : list of DETACHED entities

	}

	@Override
	public List<String> getLastNamesByEmpType(EmploymentType type) {
		List<String> lastNames = null;
		String jpql = "select e.lastName from Employee e where e.empType=:ty";
		// 1. Get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		try {
			lastNames = session.createQuery(jpql, String.class).setParameter("ty", type).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return lastNames;
	}

	@Override
	public List<Employee> getSelectedEmpsByCtorExpression(EmploymentType type1) {
		List<Employee> emps = null;
		String jpql = "select new pojos.Employee(firstName,lastName,salary) from Employee e where e.empType=:type";
		// 1. Get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		try {
			emps = session.createQuery(jpql, Employee.class).setParameter("type", type1).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return emps;
	}

	@Override
	public String updateEmpSal(String email, String pwd, double increment) {
		String mesg = "Salary updating failed....";
		String jpql = "select e from Employee e where e.email=:em and e.password=:pass";
		Employee emp = null;
		// 1. Get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		try {
			emp = session.createQuery(jpql, Employee.class).setParameter("em", email).setParameter("pass", pwd)
					.getSingleResult();// throws NoResultExc : in case of invalid login
			// => emp details valid , emp : PERSISTENT
			emp.setSalary(emp.getSalary() + increment);// modifying the state of PERSISTENT entity
			// , hib is responsible for syncing up the of L1 cache with that of DB
			// @ commit => DML : update query
			session.evict(emp);// emp : DETACHED
			tx.commit();
			mesg = "emp's salary updated....";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		emp.setSalary(emp.getSalary() + increment);
		// Hib can not track the changes made to DETACHED entity., no DMLs
		return mesg;
	}

	@Override
	public String bulkUpdateEmpSalaryByDate(double increment, LocalDate date) {
		String mesg = "Bulk updation failed.....";
		String jpql = "update Employee e set e.salary=e.salary+:incr where e.joinDate < :dt";
		// 1. Get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		try {
			int updateCount = session.createQuery(jpql).setParameter("incr", increment).setParameter("dt", date)
					.executeUpdate();
			tx.commit();
			mesg = "Updated " + updateCount + " no of emps....";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String deleteEmpDetails(Long empId) {
		String mesg="deleting emp details failed!!!!!";
		// 1. Get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		Employee emp=null;
		try {
			emp = session.get(Employee.class, empId);//select
			if (emp != null) {
				// => emp : PERSISTENT
				// mark it for the removal
				session.delete(emp);// emp : REMOVED
				mesg="emp details deleted.....";
			}
			tx.commit(); // flush---> dity checking --> delete query , session.close ---> db cn rets to
							// the pool n L1 cache destroyed
			//emp : TRANSIENT
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}//emp : marked for GC

}
