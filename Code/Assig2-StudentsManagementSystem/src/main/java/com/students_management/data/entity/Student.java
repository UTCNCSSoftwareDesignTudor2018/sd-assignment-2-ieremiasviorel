package com.students_management.data.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.students_management.constant.StatusType;

@Entity
@Table(name = "students")
public class Student extends User {

	protected static final long serialVersionUID = 8114821921433187492L;

	@ManyToOne
	@JoinColumn(name = "group_id")
	protected Group group;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	protected List<Enrollment> enrollments;

	public Student(UserInfo userInfo, AccountInfo accountInfo, Group group) {
		super();
		this.userInfo = userInfo;
		this.accountInfo = accountInfo;
		this.group = group;
		this.enrollments = new ArrayList<Enrollment>();
	}

	public Student(String firstName, String lastName, String idNumber, String address, String email, String phone,
			String username, String password, Group group) {
		this(new UserInfo(firstName, lastName, idNumber, address, email, phone),
				new AccountInfo(username, password, StatusType.ACTIVE_STATUS.asString(), calendar.getTime()), group);
	}
	
	public Student() {
		super();
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public List<Enrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}
}
