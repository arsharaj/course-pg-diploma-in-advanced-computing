package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Student;
import com.app.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	public StudentController() {
		System.out.println("Student Contoller initialized...");
	}

	@PostMapping("/add")
	public String addStudent(
			@RequestParam String fn, 
			@RequestParam String ln, 
			@RequestParam String city,
			@RequestParam String course, 
			Model map) {
		Student newStudent = new Student(fn, ln, city);
		String message = studentService.addNewStudent(newStudent, course);
		map.addAttribute("message", message);
		return "/students/result";
	}
}
