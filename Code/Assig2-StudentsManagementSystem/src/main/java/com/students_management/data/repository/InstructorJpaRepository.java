package com.students_management.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students_management.data.entity.Course;
import com.students_management.data.entity.Instructor;
import com.students_management.data.entity.Teacher;

@Repository
public interface InstructorJpaRepository extends JpaRepository<Instructor, Long> {

	public List<Instructor>	findAllByTeacher(Teacher teacher);
	
	public List<Course> findAllByCourse(Course course);
}
