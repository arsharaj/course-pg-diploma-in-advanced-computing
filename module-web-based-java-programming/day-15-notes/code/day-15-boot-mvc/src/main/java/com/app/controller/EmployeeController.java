package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.EmployeeService;

@Controller
@RequestMapping("/emps")
public class EmployeeController {
	//dep : 
	@Autowired//(required = true)
	private EmployeeService empService;
	
	public EmployeeController() {
		System.out.println("in ctor of " + getClass());
	}
	// add a req handling method to send list of emps from handler --> D.S , using
	// ModelAttrs : using Model map
	@GetMapping("/list")
	public String listEmps(Model map)
	{
		System.out.println("in list emps");
		map.addAttribute("emp_list",empService.listEmps());
		return "/emps/list";//AVN : /WEB-INF/views/emps/list.jsp
		//impl : model map 
	}
}
