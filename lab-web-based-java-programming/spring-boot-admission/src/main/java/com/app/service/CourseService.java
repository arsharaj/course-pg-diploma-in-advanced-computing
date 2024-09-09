package com.app.service;

import com.app.dto.CreateNewCourse;

public interface CourseService {
//add a method to launch new course
	String launchNewCourse(CreateNewCourse c);
	//add a method to update course fees
	String updateCourseFees(Long id, double fee);
}
