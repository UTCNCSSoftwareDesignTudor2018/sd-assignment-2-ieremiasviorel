package com.students_management.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students_management.data.entity.Course;
import com.students_management.data.entity.Instructor;
import com.students_management.data.entity.Teacher;
import com.students_management.data.repository.InstructorJpaRepository;

@Service
public class InstructorService {

	@Autowired
	private InstructorJpaRepository instructorJpaRepository;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private CourseService courseService;

	public Instructor createInstructor(Instructor Instructor) {
		return instructorJpaRepository.save(Instructor);
	}

	public Instructor createInstructor(String courseCode) {

		Teacher persistentTeacher = teacherService.getTeacher(TeacherSessionData.getLoggedInTeacher().getUsername());
		Course persistentCourse = courseService.getCourse(courseCode);

		Instructor courseTeaching = new Instructor(persistentTeacher, persistentCourse);

		persistentTeacher.addCourse(courseTeaching);

		TeacherSessionData.setLoggedInTeacher(persistentTeacher);

		return instructorJpaRepository.save(courseTeaching);
	}

	public List<Course> getTeachersCourses(Teacher teacher) {
		return instructorJpaRepository.findAllByTeacher(teacher).stream().map(e -> e.getCourse())
				.collect(Collectors.toList());
	}
}
