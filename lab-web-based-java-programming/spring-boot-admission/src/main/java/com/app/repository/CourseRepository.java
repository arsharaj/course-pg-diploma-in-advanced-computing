package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	Optional<Course> findByTitle(String courseTitle);

	//Use below approach for bulk updation , here we are updating fees of a single course!
	//check the code in service layer
//	@Modifying
//	@Query("update Course c  set c.fees=?1 where c.id=?2")
//	int updateFees(double updatedFees, Long id);

}
