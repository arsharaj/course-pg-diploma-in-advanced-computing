package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Employee;
import pojos.EmploymentType;

public interface EmployeeDao {
//add a method to save emp details
	String saveEmpDetails(Employee transientEmp,Long deptId);
	//add a method to remove an emp from specific dept
	String removeEmpFromDept(String deptName,String email);

}
