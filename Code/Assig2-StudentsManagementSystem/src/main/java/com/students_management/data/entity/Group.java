package com.students_management.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
public class Group extends BaseEntity {

	private static final long serialVersionUID = -627086939299720811L;

	@Column(name = "number", unique = true)
	protected String number;

	@Column(name = "faculty")
	protected String faculty;

	@Column(name = "specialization")
	protected String specialization;

	public Group() {
		super();
	}

	public Group(String number, String faculty, String specialization) {
		super();
		this.number = number;
		this.faculty = faculty;
		this.specialization = specialization;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
}
