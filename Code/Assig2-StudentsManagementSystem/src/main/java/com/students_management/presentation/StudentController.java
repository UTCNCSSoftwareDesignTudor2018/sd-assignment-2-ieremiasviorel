package com.students_management.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.students_management.business.GroupService;
import com.students_management.business.StudentService;
import com.students_management.data.entity.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private GroupService groupService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String insertStudent() {

		Student s = new Student("Viorel", "Ieremias", "1234567", "address", "vieremias@mail.com", "001", "vieremias", ".", groupService.findGroup("30432"));
		
		studentService.createStudent(s);
		return "OK";
	}

}
