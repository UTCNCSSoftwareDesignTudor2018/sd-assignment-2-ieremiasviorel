package com.students_management.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students_management.data.entity.Course;
import com.students_management.data.entity.Enrollment;
import com.students_management.data.entity.Teacher;
import com.students_management.data.repository.TeacherJpaRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherJpaRepository teacherJpaRepository;

	@Autowired
	private InstructorService instructorService;

	@Autowired
	private EnrollmentService enrollmentService;

	public Teacher createTeacher(Teacher teacher) {
		return teacherJpaRepository.save(teacher);
	}

	public Teacher getTeacher(String username) {
		return teacherJpaRepository.findByAccountInfoUsername(username);
	}

	public List<Teacher> getAll() {
		return teacherJpaRepository.findAll();
	}

	public Teacher updateInformation(String address, String email, String phone, String password) {

		Teacher persistentTeacher = TeacherSessionData.getLoggedInTeacher();

		persistentTeacher.setAddress(address);
		persistentTeacher.setEmail(email);
		persistentTeacher.setPhone(phone);
		persistentTeacher.setPassword(password);

		return teacherJpaRepository.save(persistentTeacher);
	}

	public void initSession(String username) {
		TeacherSessionData.setLoggedInTeacher(getTeacher(username));
		TeacherSessionData.setTeachersStudentsByCourse(getEnrollmentsGroupedByCourses(getTeacher(username)));
	}

	public List<List<Enrollment>> getEnrollmentsGroupedByCourses(Teacher teacher) {

		List<Course> teacherCourses = instructorService.getTeachersCourses(teacher);

		List<List<Enrollment>> allEnrollmentsGroupedByCourse = new ArrayList<List<Enrollment>>();

		for (Course c : teacherCourses) {
			List<Enrollment> oneCourseEnrollments = enrollmentService.getCourseEnrollments(c);
			allEnrollmentsGroupedByCourse.add(oneCourseEnrollments);
		}

		return allEnrollmentsGroupedByCourse;
	}
}
