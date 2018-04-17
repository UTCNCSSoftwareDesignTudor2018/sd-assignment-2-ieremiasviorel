package com.students_management.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructors")
public class Instructor extends BaseEntity {

	private static final long serialVersionUID = 2603893572085666396L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_id")
	protected Teacher teacher;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	protected Course course;
	
	@Column(name = "role")
	protected String role;
	
	public Instructor() {
		super();
	}
	
	public Instructor(Teacher teacher, Course course) {
		this(teacher, course, "default");
	}
	
	public Instructor(Teacher teacher, Course course, String role) {
		super();
		this.teacher = teacher;
		this.course = course;
		this.role = role;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
