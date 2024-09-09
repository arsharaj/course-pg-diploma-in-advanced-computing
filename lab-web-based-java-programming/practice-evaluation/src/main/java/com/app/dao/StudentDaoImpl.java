package com.app.dao;

import com.app.pojos.Course;
import com.app.pojos.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String addNewStudent(Student newStudent, Course course) {
		newStudent.setCourse(course);
		return "Student Successfully Added";
	}

}
