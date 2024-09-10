package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.SessionFactory;

import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoImpl;
import com.app.pojos.Employee;

public class LoadEmpDetailsById {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			// create dao instance
			EmployeeDao empDao = new EmployeeDaoImpl();
			System.out.println("Enter emp id , to fetch details");
			Employee emp = empDao.loadEmpDetailsById(sc.nextLong());
			System.out.println(emp.getClass());//proxy class
			System.out.println(emp);//LazyInitExc
		} catch (ObjectNotFoundException e) {
			System.out.println("Invalid emp id !!!!!!");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
