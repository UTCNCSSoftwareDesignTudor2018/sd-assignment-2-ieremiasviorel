package com.students_management.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students_management.data.entity.Group;

@Repository
public interface GroupJpaRepository extends JpaRepository<Group, Long> {

	public Group findByNumber(String number);
}
