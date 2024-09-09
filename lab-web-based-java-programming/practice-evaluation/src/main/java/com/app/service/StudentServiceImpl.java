package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.dao.StudentDao;
import com.app.pojos.Course;
import com.app.pojos.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private CourseDao courseDao;

	@Override
	public String addNewStudent(Student newStudent, String course) {
		Course enrollmentCourse = courseDao.getCourseByName(course);
		return studentDao.addNewStudent(newStudent, enrollmentCourse);
	}

}
