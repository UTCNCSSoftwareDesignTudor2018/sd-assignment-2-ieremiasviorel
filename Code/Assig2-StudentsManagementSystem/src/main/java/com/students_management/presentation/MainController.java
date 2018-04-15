package com.students_management.presentation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.students_management.business.StudentService;
import com.students_management.business.StudentSessionData;
import com.students_management.business.TeacherService;
import com.students_management.data.entity.Student;
import com.students_management.data.entity.Teacher;

@Controller
public class MainController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		List<Student> allStudents = studentService.findAll();
		List<Teacher> allTeachers = teacherService.findAll();
				
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("allStudents", allStudents);
		mv.addObject("allTeachers", allTeachers);

		return mv;
	}

	@RequestMapping(value = "/mainPage", method = RequestMethod.POST)
	public ModelAndView mainPage(HttpServletRequest request) {

		String username = request.getParameter("studentSelect");
		
		Student loggedInStudent = studentService.findStudent(username);
		StudentSessionData.setUser(loggedInStudent);
		
		ModelAndView mv = new ModelAndView("main_page");
		System.err.println(StudentSessionData.getUser().getEnrollments().size());
		mv.addObject("loggedInStudent", StudentSessionData.getUser());
		return mv;
	}
}
