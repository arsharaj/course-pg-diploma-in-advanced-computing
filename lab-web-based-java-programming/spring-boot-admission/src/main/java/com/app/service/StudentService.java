package com.app.service;

import java.util.List;

import com.app.dto.StudentDto;

public interface StudentService {

	String addStudentDetails(StudentDto s);
	
	List<StudentDto> getAllStudentsByCourseTitle(String courseTitle);
}
