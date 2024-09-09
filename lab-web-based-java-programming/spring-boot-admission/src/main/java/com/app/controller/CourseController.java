package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.CreateNewCourse;
import com.app.service.CourseService;

@RestController
@RequestMapping("/courses")
//un comment below line , when you are testing it with a browser app : React app
//@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@PostMapping
	// DO NOT expose entities here : rather use DTOs !
	public ResponseEntity<?> launchCourse(@RequestBody CreateNewCourse course) {
		try {
			System.out.println("in launch course " + course);
			return new ResponseEntity<>(courseService.launchNewCourse(course), HttpStatus.OK);
		} catch (RuntimeException e) {
			// currently showing simple try-catch , you can replace it by global exc handler
			// , later , not expected in lab exam , BUT expected in projects !
			return new ResponseEntity<>(new ApiResponse(e.getMessage()), HttpStatus.NOT_FOUND);
		}
	}
	
//The payload of course id n fees can instead be added in request body : as an alternative
	//currently as per the question ,added in path vars!
	@PutMapping("/{id}/fees/{fee}")
	public ResponseEntity<?> updateCourseFees(@PathVariable Long id, @PathVariable double fee ) {
		try {
			return new ResponseEntity<>(courseService.updateCourseFees(id, fee), HttpStatus.OK);
		}catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}
}
