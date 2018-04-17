package com.students_management.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students_management.data.entity.Group;

@Repository
public interface GroupJpaRepository extends JpaRepository<Group, Long> {

	public Group findByNumber(String number);
	
	public List<Group> findAllBySpecialization(String specialization);
	
	public List<Group> findAllByFaculty(String faculty);
}
