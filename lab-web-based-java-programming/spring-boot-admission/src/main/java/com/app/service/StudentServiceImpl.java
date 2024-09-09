package com.app.service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.StudentDto;
import com.app.entities.Course;
import com.app.entities.Student;
import com.app.repository.CourseRepository;
import com.app.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public String addStudentDetails(StudentDto s) {
		Course course = courseRepo.findByTitle(s.getCourseTitle())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid course title!!!"));
		// validate score
		if (s.getScore() > course.getMinScore()) {
			Student student = mapper.map(s, Student.class);
			// establish a bi dir link
			course.addStudent(student);
			Student persistentStudent = studentRepo.save(student);
			return persistentStudent.getFirstName() + " " + persistentStudent.getLastName() + " admitted in the course "+course.getTitle();
		}
		return "Student can't be admitted , Less Score!!!!";
	}

	@Override
	public List<StudentDto> getAllStudentsByCourseTitle(String courseTitle) {

		List<Student> students = studentRepo.findAllByEnrolledCourseTitle(courseTitle)
				.orElseThrow(() -> new ResourceNotFoundException("No students enrolled in course " + courseTitle));
		return students.stream().map(student -> mapper.map(student, StudentDto.class)).collect(Collectors.toList());
	}
}
