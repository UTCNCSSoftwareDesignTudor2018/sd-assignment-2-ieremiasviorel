package com.students_management.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students_management.data.entity.Teacher;
import com.students_management.data.repository.TeacherJpaRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherJpaRepository teacherJpaRepository;
	
	public List<Teacher> findAll() {
		return teacherJpaRepository.findAll();
	}
}
