package com.app.dao;

import java.util.List;

import com.app.pojos.Course;

public interface CourseDao {
	List<String> getAllCourses();
	Course getCourseByName(String courseName);
}
