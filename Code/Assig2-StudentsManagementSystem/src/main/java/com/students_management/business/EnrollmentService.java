package com.students_management.business;

import java.util.List;

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

	public Enrollment createEnrollment(String courseCode) {

		Student pesistentStudent = studentService.getStudent(StudentSessionData.getLoggedInStudent().getUsername());
		Course persistentCourse = courseService.getCourse(courseCode);

		Enrollment enrollment = new Enrollment(pesistentStudent, persistentCourse);

		pesistentStudent.addEnrollment(enrollment);

		StudentSessionData.setLoggedInStudent(pesistentStudent);
		StudentSessionData.getAvailableCourses().remove(persistentCourse);

		return enrollmentJpaRepository.save(enrollment);
	}

	public List<Enrollment> getCourseEnrollments(Course course) {
		return enrollmentJpaRepository.findAllByCourse(course);
	}
}
