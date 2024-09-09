package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.service.CourseService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	public CourseController() {
		System.out.println("Course controller initialized...");
	}
	
	@RequestMapping("/")
	public String getAllCourses(Model model) {
		System.out.println("Initial Page ...");
		model.addAttribute("courses", courseService.getAllCourses());
		return "/students/display";
	}
}
