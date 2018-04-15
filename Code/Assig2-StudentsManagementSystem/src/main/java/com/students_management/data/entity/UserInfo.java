package com.students_management.data.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserInfo {
	
	@Column(name = "first_name")
	protected String firstName;
	
	@Column(name = "last_name")
	protected String lastName;

	@Column(name = "id_number")
	protected String idNumber;
	
	@Column(name = "address")
	protected String address;

	@Column(name = "email")
	protected String email;
	
	@Column(name = "phone")
	protected String phone;
	
	public UserInfo() {
		super();
	}

	public UserInfo(String firstName, String lastName, String idNumber, String address, String email, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
