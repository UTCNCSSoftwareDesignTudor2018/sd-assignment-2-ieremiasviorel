package com.students_management.data.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 5177731068920100661L;

	@Transient
	protected static Calendar calendar = Calendar.getInstance();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	protected Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestamp")
	protected Date timestamp;	

	public BaseEntity() {
		super();
		this.timestamp = new Timestamp(calendar.getTimeInMillis());
	}
	
	public BaseEntity(Long id) {
		super();
		this.id = id;
		this.timestamp = new Timestamp(calendar.getTimeInMillis());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
