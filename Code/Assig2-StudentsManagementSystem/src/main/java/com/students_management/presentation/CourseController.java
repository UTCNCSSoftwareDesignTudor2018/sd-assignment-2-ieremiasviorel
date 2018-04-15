package com.students_management.presentation;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.students_management.business.CourseService;
import com.students_management.data.entity.Course;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String insertCourse() {

		Calendar cal = Calendar.getInstance();
		Course c = new Course("Software Design", "SD", "Nice course", cal.getTime(), cal.getTime(), cal.getTime());

		courseService.createCourse(c);
		return "OK";
	}
}
