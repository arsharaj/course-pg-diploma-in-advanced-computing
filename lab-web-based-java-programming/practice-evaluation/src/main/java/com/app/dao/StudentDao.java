package com.app.dao;

import com.app.pojos.Course;
import com.app.pojos.Student;

public interface StudentDao {
	String addNewStudent(Student newStudent, Course course);
}
