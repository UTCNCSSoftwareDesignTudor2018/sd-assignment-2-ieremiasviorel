package com.students_management.business;

import java.util.List;

import com.students_management.data.entity.Enrollment;
import com.students_management.data.entity.Teacher;

public class TeacherSessionData {

	private static Teacher loggedInTeacher;

	private static List<List<Enrollment>> teachersStudentsByCourse;

	public static Teacher getLoggedInTeacher() {
		return loggedInTeacher;
	}

	public static void setLoggedInTeacher(Teacher loggedInTeacher) {
		TeacherSessionData.loggedInTeacher = loggedInTeacher;
	}

	public static List<List<Enrollment>> getTeachersStudentsByCourse() {
		return teachersStudentsByCourse;
	}

	public static void setTeachersStudentsByCourse(List<List<Enrollment>> teachersStudentsByCourse) {
		TeacherSessionData.teachersStudentsByCourse = teachersStudentsByCourse;
	}
}
