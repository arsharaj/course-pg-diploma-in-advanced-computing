package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.AddressDao;
import com.app.dao.AddressDaoImpl;
import com.app.dao.DepartmentDao;
import com.app.dao.DepartmentDaoImpl;
import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoImpl;
import com.app.pojos.Address;
import com.app.pojos.Department;
import com.app.pojos.Employee;
import com.app.pojos.EmploymentType;

public class AssignEmpAddress {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			AddressDao dao=new AddressDaoImpl();
			System.out.println("Enter emp id");
			Long empId=sc.nextLong();
			System.out.println("Enter adr details : adrLine1,  adrLine2,  city,  state,  country,  zipCode");
			System.out.println(dao.assignEmpAddress
					(empId, new Address(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), sc.next())));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
