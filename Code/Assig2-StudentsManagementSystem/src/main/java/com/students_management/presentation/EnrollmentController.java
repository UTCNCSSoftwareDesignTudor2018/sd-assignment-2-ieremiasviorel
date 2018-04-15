package com.students_management.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.students_management.business.EnrollmentService;

@Controller
@RequestMapping("/enrollment")
public class EnrollmentController {

	@Autowired
	private EnrollmentService enrollmentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String insertEnrollment() {
		
		enrollmentService.createEnrollment("vieremias", "SD");
		
		return "OK";
	}
}
