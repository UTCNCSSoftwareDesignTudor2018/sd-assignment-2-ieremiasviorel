package com.students_management.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students_management.data.entity.Course;
import com.students_management.data.repository.CourseJpaRepository;

@Service
public class CourseService {

	@Autowired
	private CourseJpaRepository courseJpaRepository;

	public Course createCourse(Course course) {

		return courseJpaRepository.save(course);
	}
	
	public Course findCourse(String code) {
		return courseJpaRepository.findByCourseInfoCode(code);
	}
}
