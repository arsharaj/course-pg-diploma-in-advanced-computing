package com.cdac.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.pojos.Student;

public interface StudentDao extends JpaRepository<Student, Long>{

}
