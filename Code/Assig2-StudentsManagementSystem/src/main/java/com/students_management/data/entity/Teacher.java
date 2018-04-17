package com.students_management.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.students_management.constant.StatusType;

@Entity
@Table(name = "teachers")
public class Teacher extends User {

	private static final long serialVersionUID = 2026186525008141065L;

	@OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
	protected List<Instructor> courses;

	public Teacher() {
		super();
	}

	public Teacher(UserInfo userInfo, AccountInfo accountInfo) {
		super();
		this.userInfo = userInfo;
		this.accountInfo = accountInfo;
		this.courses = new ArrayList<Instructor>();
	}

	public Teacher(String firstName, String lastName, String idNumber, String address, String email, String phone,
			String username, String password) {
		this(new UserInfo(firstName, lastName, idNumber, address, email, phone),
				new AccountInfo(username, password, StatusType.ACTIVE_STATUS.asString(), calendar.getTime()));
	}

	public List<Instructor> getCourses() {
		return courses;
	}

	public void setCourses(List<Instructor> courses) {
		this.courses = courses;
	}
	
	public void addCourse(Instructor course) {
		courses.add(course);
	}
}
