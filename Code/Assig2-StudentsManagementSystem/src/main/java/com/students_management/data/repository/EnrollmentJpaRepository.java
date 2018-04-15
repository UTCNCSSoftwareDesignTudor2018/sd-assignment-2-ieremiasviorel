package com.students_management.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students_management.data.entity.Course;
import com.students_management.data.entity.Enrollment;
import com.students_management.data.entity.Student;

@Repository
public interface EnrollmentJpaRepository extends JpaRepository<Enrollment, Long> {

	public List<Enrollment> findAllByStudent(Student student);
	
	public List<Enrollment> findAllByCourse(Course course);
}
