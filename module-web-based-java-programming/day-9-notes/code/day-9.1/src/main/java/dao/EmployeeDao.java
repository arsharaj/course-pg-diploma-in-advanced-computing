package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Employee;
import pojos.EmploymentType;

public interface EmployeeDao {
//add a method to save emp details
	String saveEmpDetails(Employee transientEmp);

	// add a method to find emp details by id
	Employee getEmpDetailsById(long empId);// long --> Long --> Serializable
	// add a method to find all emps

	List<Employee> getAllEmps();

	// add a method to find all emps by some criteria
	/*
	 * Display all employees joined within date range n drawing sal > specific
	 * salary
	 */
	List<Employee> getSelectedEmps(LocalDate begin, LocalDate end, double minSal);

	// get list of last names of a specified emp type
	List<String> getLastNamesByEmpType(EmploymentType type);

	// get all emp first n last names n salary of a specific employment type
	List<Employee> getSelectedEmpsByCtorExpression(EmploymentType type);
	//add a new method to update emp salary
	String updateEmpSal(String email,String pwd,double increment);
	
}
