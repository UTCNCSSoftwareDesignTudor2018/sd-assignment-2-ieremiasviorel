package com.students_management.data.entity;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class User extends BaseEntity {

	private static final long serialVersionUID = -4118882973652546269L;

	@Embedded
	protected UserInfo userInfo;

	@Embedded
	protected AccountInfo accountInfo;

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public AccountInfo getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}

	public String getFirstName() {
		return getUserInfo().getFirstName();
	}

	public void setFirstName(String firstName) {
		getUserInfo().setFirstName(firstName);
	}

	public String getLastName() {
		return getUserInfo().getLastName();
	}

	public void setLastName(String lastName) {
		getUserInfo().setLastName(lastName);
	}

	public String getIdNumber() {
		return getUserInfo().getIdNumber();
	}

	public void setIdNumber(String idNumber) {
		getUserInfo().setIdNumber(idNumber);
	}

	public String getAddress() {
		return getUserInfo().getAddress();
	}

	public void setAddress(String address) {
		getUserInfo().setAddress(address);
	}

	public String getEmail() {
		return getUserInfo().getEmail();
	}

	public void setEmail(String email) {
		getUserInfo().setEmail(email);
	}

	public String getPhone() {
		return getUserInfo().getPhone();
	}

	public void setPhone(String phone) {
		getUserInfo().setPhone(phone);
	}
	
	public String getUsername() {
		return getAccountInfo().getUsername();
	}

	public void setUsername(String username) {
		getAccountInfo().setUsername(username);
	}

	public String getPassword() {
		return getAccountInfo().getPassword();
	}

	public void setPassword(String password) {
		getAccountInfo().setPassword(password);
	}

	public String getStatus() {
		return getAccountInfo().getStatus();
	}

	public void setStatus(String status) {
		getAccountInfo().setStatus(status);
	}

	public Date getRegistrationDate() {
		return getAccountInfo().getRegistrationDate();
	}

	public void setRegistrationDate(Date registrationDate) {
		getAccountInfo().setRegistrationDate(registrationDate);
	}
}
