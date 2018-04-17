package com.students_management.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students_management.data.entity.Course;
import com.students_management.data.entity.Enrollment;
import com.students_management.data.entity.Student;
import com.students_management.data.repository.CourseJpaRepository;

@Service
public class CourseService {

	@Autowired
	private CourseJpaRepository courseJpaRepository;

	public Course createCourse(Course course) {

		return courseJpaRepository.save(course);
	}

	public Course getCourse(String code) {
		return courseJpaRepository.findByCourseInfoCode(code);
	}

	public List<Course> getAll() {
		return courseJpaRepository.findAll();
	}

	public List<Course> getStudentAvailableCourses(Student student) {
		
		
		List<Enrollment> studentEnrollments = student.getEnrollments();
		List<Course> alreadyEnrolledCourses = studentEnrollments.stream().map(e -> e.getCourse())
				.collect(Collectors.toList());

		List<Course> availableCourses = courseJpaRepository.findAll();
		availableCourses.removeAll(alreadyEnrolledCourses);

		return availableCourses;
	}

	public void initSession() {
		Student student = StudentSessionData.getLoggedInStudent();
		StudentSessionData.setAvailableCourses(getStudentAvailableCourses(student));
	}

}
