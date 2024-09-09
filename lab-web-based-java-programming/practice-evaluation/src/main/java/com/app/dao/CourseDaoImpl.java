package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Course;

@Repository
public class CourseDaoImpl implements CourseDao {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<String> getAllCourses() {
		String jpql = "select c.courseName from Course c";
		return entityManager.createQuery(jpql, String.class).getResultList();
	}

	@Override
	public Course getCourseByName(String courseName) {
		String jpql = "select c.courseName from Course c where c.courseName = :course";
		return entityManager.createQuery(jpql, Course.class).setParameter("course", courseName).getSingleResult();
	}

}
