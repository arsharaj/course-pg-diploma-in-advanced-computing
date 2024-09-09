package com.cdac.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cdac.dao.StudentDao;
import com.cdac.pojos.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	public StudentServiceImpl(StudentDao studentDao) {
		super();
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDao.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentDao.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentDao.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentDao.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentDao.deleteById(id);
	}

}
