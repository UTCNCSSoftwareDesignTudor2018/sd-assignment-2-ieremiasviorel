package com.students_management.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enrollments")
public class Enrollment extends BaseEntity {

	private static final long serialVersionUID = -8609108076637770386L;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	protected Student student;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "course_id")
	protected Course course;

	@Column(name = "grade")
	protected Float grade;

	public Enrollment() {
		super();
	}
	
	public Enrollment(Student student, Course course) {
		this(student, course, null);
	}

	public Enrollment(Student student, Course course, Float grade) {
		super();
		this.student = student;
		this.course = course;
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Float getGrade() {
		return grade;
	}

	public void setGrade(Float grade) {
		this.grade = grade;
	}
}
