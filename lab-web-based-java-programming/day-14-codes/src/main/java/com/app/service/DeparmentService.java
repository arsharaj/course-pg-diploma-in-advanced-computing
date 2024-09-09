package com.app.service;

import java.util.List;

import com.app.pojos.Department;
import com.app.pojos.Employee;

public interface DeparmentService {
	//add a method to list all the depts
	List<Department> listAllDepartments();

	// add a method to list all the depts
	List<Employee> listAllEmployees(String dept);
}
