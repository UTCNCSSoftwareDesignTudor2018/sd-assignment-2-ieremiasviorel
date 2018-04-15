package com.students_management.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students_management.data.entity.Student;
import com.students_management.data.repository.StudentJpaRepository;

@Service
public class StudentService {

	@Autowired
	private StudentJpaRepository studentJpaRepository;

	public Student createStudent(Student student) {
		return studentJpaRepository.save(student);
	}

	public Student findStudent(String username) {
		return studentJpaRepository.findByAccountInfoUsername(username);
	}
	
	public List<Student> findAll() {
		return studentJpaRepository.findAll();
	}
}
