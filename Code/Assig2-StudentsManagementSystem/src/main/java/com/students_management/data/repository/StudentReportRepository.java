package com.students_management.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.students_management.data.entity.StudentReport;

@Repository
public interface StudentReportRepository extends MongoRepository<StudentReport, Long> {

}
