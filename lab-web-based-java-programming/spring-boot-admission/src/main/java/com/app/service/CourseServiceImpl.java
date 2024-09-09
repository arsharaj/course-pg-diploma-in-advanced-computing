package com.app.service;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.CreateNewCourse;
import com.app.entities.Course;
import com.app.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public String launchNewCourse(CreateNewCourse course) {
		Course persistentCourse = courseRepo.save(mapper.map(course, Course.class));
		return persistentCourse.getTitle() + " course added....";
	}

	@Override
	public String updateCourseFees(Long id, double fees) {
		// get course by it's id
		Course course = courseRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Course ID!!!!!"));
		// course : PERSISTENT , simply modify the state
		course.setFees(fees);
		return "Updated course fees of " + course.getTitle() + " to new fees : " + fees;
	}

}
