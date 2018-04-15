package com.students_management.data.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "courses")
public class Course extends BaseEntity {

	protected static final long serialVersionUID = 6087935885122043223L;

	@Embedded
	protected CourseInfo courseInfo;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date")
	protected Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date")
	protected Date endDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "exam_date")
	protected Date examDate;

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	protected List<Enrollment> students;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
	protected List<Instructor> teachers;

	public Course(String name, String code, String description, Date startDate, Date endDate, Date examDate) {
		CourseInfo courseInfo = new CourseInfo(name, code, description);
		this.courseInfo = courseInfo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.examDate = examDate;
		this.students = new ArrayList<Enrollment>();
		this.teachers = new ArrayList<Instructor>();
	}
	
	public Course() {
		super();
	}
	
	public CourseInfo getCourseInfo() {
		return courseInfo;
	}

	public void setCourseInfo(CourseInfo courseInfo) {
		this.courseInfo = courseInfo;
	}
	
	public String getCode() {
		return getCourseInfo().getCode();
	}
	
	public void setCode(String code) {
		getCourseInfo().setCode(code);
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
}
