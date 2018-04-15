package com.students_management.data.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CourseInfo {

	@Column(name = "name")
	protected String name;

	@Column(name = "code", unique = true)
	protected String code;

	@Column(name = "description")
	protected String description;
	
	public CourseInfo() {
		super();
	}

	public CourseInfo(String name, String code, String description) {
		super();
		this.name = name;
		this.code = code;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
