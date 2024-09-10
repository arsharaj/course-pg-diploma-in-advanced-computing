package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDTO;
import com.app.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	// dep : service layer i/f
	@Autowired
	private StudentService studentService;

	public StudentController() {
		System.out.println("in ctor of " + getClass());
	}

	// add REST API end point to add student details
	// URL : http://host:port/students , method=POST
	// request payload : StudentDTO : no id
	// resp : success --SC 201 , StudentDTO : id
	// resp : err --SC 500, Api Resp DTO
	@PostMapping
	public ResponseEntity<?> addNewStudent
	(@RequestBody StudentDTO dto) {
		System.out.println("in add student " + dto);
		try {
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(studentService.addStudentDetails(dto));
		} catch (RuntimeException e) {
			System.out.println("err " + e);
			// return ResponseEntity : SC 500
			// ApiResp DTO : mesg n timestamp
			return ResponseEntity.status
					(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse(e.getMessage()));
		}
	}

}
