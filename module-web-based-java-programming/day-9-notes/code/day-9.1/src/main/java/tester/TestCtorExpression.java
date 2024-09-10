package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import pojos.Employee;
import pojos.EmploymentType;

public class TestCtorExpression {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			// create dao instance
			EmployeeDao empDao = new EmployeeDaoImpl();
			System.out.println("Enter employment type");
			List<Employee> list = empDao
					.getSelectedEmpsByCtorExpression(EmploymentType.valueOf(sc.next().toUpperCase()));
			System.out.println("Selected emps : ");
			list.forEach(e -> System.out.println(e.getFirstName() + " " + e.getLastName() + " " + e.getSalary()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
