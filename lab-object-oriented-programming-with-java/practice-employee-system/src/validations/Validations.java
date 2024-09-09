package validations;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import core.Employee;
import core.FullTime;
import core.PartTime;
import exception.EmployeeException;

public class Validations {

	public static Employee validateEmployee(Scanner sc, HashMap<Integer, Employee> employeesMap, boolean isFullTime)
			throws EmployeeException {
		System.out.println("Enter your details : (name, dateOfJoining, phone, aadhar)");
		String name = sc.next();
		LocalDate dateOfJoining = LocalDate.parse(sc.next());
		String phone = sc.next();
		String aadhar = sc.next();
		if (!(phone.matches("^[0-9]*$") && phone.length() == 10)) {
			throw new EmployeeException("Invalid phone number.");
		}
		if (!(aadhar.matches("^\\S+$") && aadhar.length() == 12)) {
			throw new EmployeeException("Invalid aadhar number.");
		} else {
			if (employeesMap.values().stream().anyMatch(emp -> emp.getAadhar().equals(aadhar))) {
				throw new EmployeeException("Aadhar already present.");
			} else {
				if (isFullTime) {
					System.out.println("Enter monthly salary : ");
					double salary = sc.nextDouble();
					if (salary < 0) {
						throw new EmployeeException("Invalid Salary.");
					} else {
						return new FullTime(name, dateOfJoining, phone, aadhar, salary);
					}
				} else {
					System.out.println("Enter hourly salary : ");
					double salary = sc.nextDouble();
					if (salary < 0) {
						throw new EmployeeException("Invalid Salary.");
					} else {
						return new PartTime(name, dateOfJoining, phone, aadhar, salary);
					}
				}
			}
		}
	}

}
