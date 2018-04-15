package com.students_management.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students_management.data.entity.Course;
import com.students_management.data.entity.Enrollment;
import com.students_management.data.entity.Student;
import com.students_management.data.repository.EnrollmentJpaRepository;

@Service
public class EnrollmentService {

	@Autowired
	private EnrollmentJpaRepository enrollmentJpaRepository;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	public Enrollment createEnrollment(Enrollment enrollment) {
		return enrollmentJpaRepository.save(enrollment);
	}
	
	public Enrollment createEnrollment(String studentUsername, String courseCode) {
		Student pesistentStudent = studentService.findStudent(studentUsername);
		Course persistentCourse = courseService.findCourse(courseCode);
		
		Enrollment enrollment = new Enrollment(pesistentStudent, persistentCourse);
		
		return enrollmentJpaRepository.save(enrollment);
	}
}
