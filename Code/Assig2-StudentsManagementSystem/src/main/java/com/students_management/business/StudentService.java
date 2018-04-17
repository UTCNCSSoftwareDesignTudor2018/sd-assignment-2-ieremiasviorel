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

	public Student getStudent(String username) {
		return studentJpaRepository.findByAccountInfoUsername(username);
	}
	
	public List<Student> getAll() {
		return studentJpaRepository.findAll();
	}
	
	public Student updateInformation(String address, String email, String phone, String password) {
		
		Student persistentStudent = StudentSessionData.getLoggedInStudent();
		
		persistentStudent.setAddress(address);
		persistentStudent.setEmail(email);
		persistentStudent.setPhone(phone);
		persistentStudent.setPassword(password);
		
		return studentJpaRepository.save(persistentStudent);
	}
	
	public void initSession(String username) {
		StudentSessionData.setLoggedInStudent(getStudent(username));
	}
}
