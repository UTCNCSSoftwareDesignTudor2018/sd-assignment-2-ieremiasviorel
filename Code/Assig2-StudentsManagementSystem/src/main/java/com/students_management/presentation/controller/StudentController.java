package com.students_management.presentation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.students_management.business.CourseService;
import com.students_management.business.EnrollmentService;
import com.students_management.business.StudentReportService;
import com.students_management.business.StudentService;
import com.students_management.business.StudentSessionData;
import com.students_management.data.entity.Student;
import com.students_management.data.entity.StudentReport;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private EnrollmentService enrollmentService;

	@Autowired
	private StudentReportService studentReportService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {

		List<Student> allStudents = studentService.getAll();

		ModelAndView mv = new ModelAndView("student_login");
		mv.addObject("allStudents", allStudents);

		return mv;
	}

	@RequestMapping(value = "/mainPage", method = RequestMethod.POST)
	public ModelAndView mainPage(HttpServletRequest request) {

		String username = request.getParameter("studentSelect");

		studentService.initSession(username);
		courseService.initSession();

		ModelAndView mv = new ModelAndView("student_main_page");

		mv.addObject("loggedInStudent", StudentSessionData.getLoggedInStudent());
		mv.addObject("unenrolledCourses", StudentSessionData.getAvailableCourses());

		return mv;
	}

	@RequestMapping(value = "/mainPage", method = RequestMethod.GET)
	public ModelAndView mainPageReload(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("student_main_page");

		mv.addObject("loggedInStudent", StudentSessionData.getLoggedInStudent());
		mv.addObject("unenrolledCourses", StudentSessionData.getAvailableCourses());

		return mv;
	}

	@RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
	public RedirectView updateInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");

		studentService.updateInformation(address, email, phone, password);
		StudentReport sr = new StudentReport(StudentSessionData.getLoggedInStudent().getUsername(), "EDIT_PROFILE");
		sr.setId(Long.valueOf(1));
		studentReportService.submitReport(sr);
		return new RedirectView("/students/mainPage");
	}

	@RequestMapping(value = "/enrollCourse", method = RequestMethod.POST)
	public RedirectView enrollCourse(HttpServletRequest request, @RequestBody String[] courseCodes) {

		for (String courseCode : courseCodes) {
			enrollmentService.createEnrollment(courseCode);
		}
		
		return new RedirectView("/students/mainPage");
	}
}
