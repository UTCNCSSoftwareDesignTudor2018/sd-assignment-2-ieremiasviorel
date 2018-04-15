package com.students_management.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students_management.data.entity.Teacher;

@Repository
public interface TeacherJpaRepository extends JpaRepository<Teacher, Long> {

	public Teacher findByAccountInfoUsername(String username);
	
	public Teacher findByAccountInfoUsernameAndAccountInfoPassword(String username, String password);
}
