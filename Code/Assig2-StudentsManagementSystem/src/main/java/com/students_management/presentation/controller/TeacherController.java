package com.students_management.presentation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.students_management.business.TeacherService;
import com.students_management.business.TeacherSessionData;
import com.students_management.data.entity.Teacher;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

//	@Autowired
//	private CourseService courseService;
//
//	@Autowired
//	private InstructorService instrusctorService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {

		List<Teacher> allTeachers = teacherService.getAll();

		ModelAndView mv = new ModelAndView("teacher_login");
		mv.addObject("allTeachers", allTeachers);

		return mv;
	}

	@RequestMapping(value = "/mainPage", method = RequestMethod.POST)
	public ModelAndView mainPage(HttpServletRequest request) {

		String username = request.getParameter("teacherSelect");

		teacherService.initSession(username);

		ModelAndView mv = new ModelAndView("teacher_main_page");

		mv.addObject("loggedInTeacher", TeacherSessionData.getLoggedInTeacher());
		mv.addObject("enrolledStudents", TeacherSessionData.getTeachersStudentsByCourse());
		
		return mv;
	}

	@RequestMapping(value = "/mainPage", method = RequestMethod.GET)
	public ModelAndView mainPageReload(HttpServletRequest request) {

		ModelAndView mv = new ModelAndView("teacher_main_page");

		mv.addObject("loggedInTeacher", TeacherSessionData.getLoggedInTeacher());
		mv.addObject("enrolledStudents", TeacherSessionData.getTeachersStudentsByCourse());

		return mv;
	}

	@RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
	public RedirectView updateInfo(HttpServletRequest request) {

		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");

		teacherService.updateInformation(address, email, phone, password);

		return new RedirectView("/teachers/mainPage");
	}
}
