package com.students_management.constant;

public class StatusType {

	protected String statusType;
	
	public StatusType(String statusType) {
		this.statusType = statusType;
	}
	
	public static final StatusType ACTIVE_STATUS = new StatusType("ACTIVE");
	public static final StatusType PENDING_STATUS = new StatusType("PENDING");
	public static final StatusType DISABLED_STATUS = new StatusType("DISABLED");
	public static final StatusType REMOVED_STATUS = new StatusType("REMOVED");;
	
	public static StatusType[] values = {
			ACTIVE_STATUS, PENDING_STATUS, DISABLED_STATUS, REMOVED_STATUS
	};
	
	public static StatusType[] values() {
		return values;
	}
	
	public StatusType valueOf(String statusAsString) {
		for (StatusType s : values) {
			if (statusAsString.equals(s.statusType)) {
				return s;
			}
		}
		return null;
	}
	
	public String asString() {
		return this.statusType;
	}
}
