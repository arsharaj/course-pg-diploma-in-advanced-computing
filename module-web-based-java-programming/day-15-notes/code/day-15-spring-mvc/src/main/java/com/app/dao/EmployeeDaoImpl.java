package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	//dep : 
	@Autowired //byType
	private SessionFactory sf;

	@Override
	public List<Employee> getAllEmps() {
		String jpql="select e from Employee e join fetch e.myDept";
		return sf.getCurrentSession()
				.createQuery(jpql, Employee.class)
				.getResultList();
	}

}
