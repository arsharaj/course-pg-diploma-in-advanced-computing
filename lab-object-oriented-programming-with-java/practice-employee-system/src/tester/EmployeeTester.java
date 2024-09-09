package tester;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import core.Employee;
import core.FullTime;
import core.PartTime;
import utils.Utils;

public class EmployeeTester {
	public static HashMap<Integer, Employee> employeesMap = new HashMap<>();

	public static void main(String[] args) {
//		populateMap();
		try {
			employeesMap = Utils.restore();
			System.out.println("Employee details restore from file named Employee.ser ");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		try (Scanner sc = new Scanner(System.in)) {
			int choice = 0;
			do {
				try {
					System.out.println("Application Menu:\r\n" + "1. Add full time employee\r\n"
							+ "2. Add part time employee\r\n" + "3. Delete an employee by Emp Id\r\n"
							+ "4. Search employee details by Aadhaar number\r\n" + "5. Display all employee details\r\n"
							+ "6. Display all employee details sorted by date of joining\r\n" + "0. Exit\r\n");
					System.out.println("Enter your choice : ");
					choice = sc.nextInt();
					switch (choice) {
					case 1:
						Utils.addFullTimeEmployee(sc, employeesMap);
						break;
					case 2:
						Utils.addPartTimeEmployee(sc, employeesMap);
						break;
					case 3:
						Utils.deleteEmpById(sc, employeesMap);
						break;
					case 4:
						Utils.searchByAadhar(sc, employeesMap);
						break;
					case 5:
						Utils.displayAll(employeesMap);
						break;
					case 6:
						Utils.displayAllSortedByDOJ(employeesMap);
						break;
					case 0:
						Utils.store(employeesMap);
						System.out.println("Thank you for using our services.");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} while (choice != 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void populateMap() {
		employeesMap.put(1, new PartTime("sahil", LocalDate.parse("2023-08-02"), "8600386608", "471616721623", 200));
		employeesMap.put(2, new FullTime("amar", LocalDate.parse("2023-07-01"), "1000386608", "471616721612", 20000));
		employeesMap.put(3, new PartTime("arsh", LocalDate.parse("2023-04-23"), "842386608", "471616721613", 100));
		employeesMap.put(4, new FullTime("sam", LocalDate.parse("2023-08-02"), "1286086608", "471616721212", 40000));
		employeesMap.put(5, new FullTime("arav", LocalDate.parse("2021-07-02"), "2340386608", "471616712623", 80000));
	}

}
