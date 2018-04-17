package com.students_management.business;

import java.util.List;

import com.students_management.data.entity.Course;
import com.students_management.data.entity.Student;

public class StudentSessionData {

	private static Student loggedInStudent;
	
	private static List<Course> availableCourses;
	
	public static Student getLoggedInStudent() {
		return loggedInStudent;
	}

	public static void setLoggedInStudent(Student loggedInStudent) {
		StudentSessionData.loggedInStudent = loggedInStudent;
	}

	public static List<Course> getAvailableCourses() {
		return availableCourses;
	}

	public static void setAvailableCourses(List<Course> availableCourses) {
		StudentSessionData.availableCourses = availableCourses;
	}
}
