package com.students_management.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students_management.data.entity.StudentReport;
import com.students_management.data.repository.StudentReportRepository;

@Service
public class StudentReportService {

	@Autowired
	private StudentReportRepository studentReportRepository;
	
	public void submitReport(StudentReport studentReport) {
		studentReportRepository.save(studentReport);
	}
}
