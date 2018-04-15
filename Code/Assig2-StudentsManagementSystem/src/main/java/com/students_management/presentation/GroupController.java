package com.students_management.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.students_management.business.GroupService;
import com.students_management.data.entity.Group;

@Controller
@RequestMapping("/group")
public class GroupController {

	@Autowired
	private GroupService groupService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String insertGroup() {
		
		groupService.createGroup(new Group("30432", "AC", "CS"));
		return "OK";
	}
}
