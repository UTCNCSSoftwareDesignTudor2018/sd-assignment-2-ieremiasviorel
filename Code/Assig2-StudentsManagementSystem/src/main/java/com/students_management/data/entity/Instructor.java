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
}
