package com.app.dao;

import java.util.List;

import com.app.pojos.Department;
import com.app.pojos.Employee;

public interface DepartmentDao {
//add a method to create new dept
//	String addNewDepartment(Department dept);
//
//	// add a method to display dept details ONLY
//	Department getDepartmentDetails(String deptName);
//
//	// add a method to display dept details+emp details
//	Department getDepartmentAndEmpDetails(String deptName);
//
//	// add a method to display dept details+emp details , in a single join query
//	Department getDepartmentAndEmpDetailsJoinFetch(String deptName);
//
//	// add a method to delete dept details
//	String deleteDeptDetails(String deptName);
	// add a method to display all depts details(w/o emps)
	List<Department> getAllDepartments();

	// Get all list of emps within a dept
	List<Employee> getAllEmployees(String dept);
}
