package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.pojos.Employee;
import com.app.service.DeparmentService;

@Controller
public class DepartmentControllerTwo {
	// dependency : service layer i/f
	@Autowired
	private DeparmentService deptService;

	public DepartmentControllerTwo() {
		System.out.println("in ctor of " + getClass());
	}

	// add req handling method to send list of depts to the view layers
	@RequestMapping("/emps_list")
	public String listAllEmps(Model modelAttrMap, HttpServletRequest request) {
		System.out.println("in list all emps " + modelAttrMap);// {}
		System.out.println("Request Parameter : " + modelAttrMap);
		List<Employee> listAllEmployees = deptService
				.listAllEmployees(request.getParameter("selected_dept"));
		modelAttrMap.addAttribute("emps_list", listAllEmployees);
		return "emps";// AVN :
		// /WEB-INF/views/list.jsp--> D.S forwards --> list.jsp
	}
}
