package com.students_management.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students_management.data.entity.Student;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Long> {

	public Optional<Student> findById(Long id);
	
	public Student findByAccountInfoUsername(String username);
	
	public Student findByAccountInfoUsernameAndAccountInfoPassword(String username, String password);
}
