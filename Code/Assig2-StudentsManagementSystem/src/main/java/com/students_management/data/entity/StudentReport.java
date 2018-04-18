package com.students_management.data.entity;

public class StudentReport extends BaseEntity {

	private static final long serialVersionUID = -700708419647623461L;

	private String username;
	private String actionType;

	public StudentReport(String username, String actionType) {
		super();
		this.username = username;
		this.actionType = actionType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
}
