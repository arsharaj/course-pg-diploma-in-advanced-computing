package com.app.tester;

import static com.app.utils.HibernateUtils.getFactory;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.app.dao.DepartmentDao;
import com.app.dao.DepartmentDaoImpl;
import com.app.pojos.Department;

public class DisplayAllDepartmentDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			DepartmentDao dao = new DepartmentDaoImpl();
			System.out.println("All Department Details");
			List<Department> departmentList = dao.getAllDeptDetails();
			for (Department department : departmentList) {
				System.out.println("Dept details ");
				System.out.println(department);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
