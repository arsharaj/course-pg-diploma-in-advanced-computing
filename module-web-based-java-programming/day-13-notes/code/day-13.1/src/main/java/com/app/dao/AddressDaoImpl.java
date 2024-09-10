package com.app.dao;

import static com.app.utils.HibernateUtils.getFactory;

import org.hibernate.*;

import com.app.pojos.Address;
import com.app.pojos.Employee;

public class AddressDaoImpl implements AddressDao {

	@Override
	public String assignEmpAddress(Long empId, Address adr) {
		String mesg="assigning adr failed : invalid emp id";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();

		try {
			// get persistent emp from DB
			Employee emp = session.get(Employee.class, empId);
			if (emp != null) {
				// emp exists : persistent
				// establish uni dir link adr --> emp
				adr.setEmp(emp);
				session.persist(adr);
				mesg="Assigned adr to emp "+emp.getFirstName();
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}
