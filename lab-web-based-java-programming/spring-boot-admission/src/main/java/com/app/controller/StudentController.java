package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDto;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
//un comment  line below , when you attach React front end
//@CrossOrigin(origins = "http://localhost:3000")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping
	public ResponseEntity<?> addStudent(@RequestBody StudentDto s) {
		try {
			System.out.println("in add student "+s);
			return new ResponseEntity<>(new ApiResponse(studentService.addStudentDetails(s)), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}

	@GetMapping("/course_title/{courseTitle}")
	public ResponseEntity<?> getAllStudentsByCourseTitle(@PathVariable String courseTitle) {
		try {

			System.out.println("in get students by course "+courseTitle);
			return new ResponseEntity<>(studentService.getAllStudentsByCourseTitle(courseTitle), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}

	}

}
