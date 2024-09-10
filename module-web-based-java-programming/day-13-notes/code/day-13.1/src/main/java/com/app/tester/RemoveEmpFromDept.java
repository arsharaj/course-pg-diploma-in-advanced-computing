package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoImpl;
import com.app.pojos.Employee;
import com.app.pojos.EmploymentType;

public class RemoveEmpFromDept {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			// create dao instance
			EmployeeDao empDao = new EmployeeDaoImpl();
			System.out.println(
					"Enter dept name n emp's email , to be removed");
				System.out.println(empDao.removeEmpFromDept(sc.next(),sc.next()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
