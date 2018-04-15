package com.students_management.business;

import com.students_management.data.entity.Student;

public class StudentSessionData {

	private static Student loggedInStudent;
	
	public static Student getUser() {
		return loggedInStudent;
	}
	
	public static void setUser(Student student) {
		loggedInStudent = student;
	}
}
