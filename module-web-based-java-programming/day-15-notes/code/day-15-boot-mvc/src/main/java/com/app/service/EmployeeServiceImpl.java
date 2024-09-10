package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.EmployeeDao;
import com.app.pojos.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	//dep
	@Autowired
	private EmployeeDao empDao;

	@Override
	public List<Employee> listEmps() {
		// TODO Auto-generated method stub
		List<Employee> emps = empDao.getAllEmps();
		emps.forEach(e -> e.getMyDept().getName());
		return emps;
	}

}
