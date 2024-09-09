package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

import core.Employee;
import exception.EmployeeException;
import validations.Validations;

public class Utils {

	public static void addFullTimeEmployee(Scanner sc, HashMap<Integer, Employee> employeesMap)
			throws EmployeeException {
		Employee emp = Validations.validateEmployee(sc, employeesMap, true);
		employeesMap.put(emp.getEmpId(), emp);
		System.out.println("Full time employee added." + emp.getEmpId());
	}

	public static void addPartTimeEmployee(Scanner sc, HashMap<Integer, Employee> employeesMap)
			throws EmployeeException {
		Employee emp = Validations.validateEmployee(sc, employeesMap, false);
		employeesMap.put(emp.getEmpId(), emp);
		System.out.println("Part time employee added." + emp.getEmpId());
	}

	public static void deleteEmpById(Scanner sc, HashMap<Integer, Employee> employeesMap) throws EmployeeException {
		System.out.println("Enter the employee id to be removed");
		int empId = sc.nextInt();
		if (employeesMap.remove(empId) != null) {
			System.out.println("Emp removed successfully.");
		} else {
			throw new EmployeeException("Employee not found.");
		}
	}

	public static void searchByAadhar(Scanner sc, HashMap<Integer, Employee> employeesMap) {
		System.out.println("Enter the aadhar to be searched");
		String aadhar = sc.next();
		Employee employee = employeesMap.values().stream().filter(emp -> emp.getAadhar().equals(aadhar)).findFirst()
				.orElseThrow();
		if (employee != null) {
			System.out.println("Employee details : ");
			System.out.println(employee);
		} else {
			System.out.println("Employee not found.");
		}
	}

	public static void displayAll(HashMap<Integer, Employee> employeesMap) {
		System.out.println("All employee details : ");
		employeesMap.forEach((empId, employee) -> System.out.println(employee));
	}

	public static void displayAllSortedByDOJ(HashMap<Integer, Employee> employeesMap) {
		System.out.println("All employee details sorted by date of joining : ");
		employeesMap.values().stream().sorted((e1, e2) -> e1.getDateOfJoining().compareTo(e2.getDateOfJoining()))
				.forEach((employee) -> System.out.println(employee));
	}

	public static void store(HashMap<Integer, Employee> employeesMap) throws FileNotFoundException, IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Employee.ser"))) {
			out.writeObject(employeesMap);
			System.out.println("Employee details saved in file named Employee.ser ");
		}
	}

	@SuppressWarnings("unchecked")
	public static HashMap<Integer, Employee>  restore() throws ClassNotFoundException, IOException {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Employee.ser"))) {
			HashMap<Integer, Employee> employeesMap = (HashMap<Integer, Employee>) in.readObject();
			return employeesMap;
		
		}

	}

}
