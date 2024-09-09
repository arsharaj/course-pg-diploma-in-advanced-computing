package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Department;
import com.app.pojos.Employee;
import com.app.service.DeparmentService;

@Controller
public class DepartmentController {
	// dependency : service layer i/f
	@Autowired
	private DeparmentService deptService;

	public DepartmentController() {
		System.out.println("in ctor of " + getClass());
	}

	// add req handling method to send list of depts to the view layer.
	@RequestMapping("/dept_list")
	public String listAllDepts(Model modelAttrMap) {
		System.out.println("in list all depts " + modelAttrMap);// {}
		List<Department> listAllDepartments = deptService.listAllDepartments();
		modelAttrMap.addAttribute("dept_list", listAllDepartments);
		return "/list";// AVN :
		// /WEB-INF/views/list.jsp--> D.S forwards --> list.jsp
	}


}
