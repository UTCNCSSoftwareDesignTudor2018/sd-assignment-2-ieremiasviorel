package com.students_management.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students_management.data.entity.Course;

@Repository
public interface CourseJpaRepository extends JpaRepository<Course, Long> {

	public Optional<Course> findById(Long id);
	
	public Course findByCourseInfoCode(String code);
}
