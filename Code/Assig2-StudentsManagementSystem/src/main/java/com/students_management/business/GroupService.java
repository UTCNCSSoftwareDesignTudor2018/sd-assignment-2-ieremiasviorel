package com.students_management.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students_management.data.entity.Group;
import com.students_management.data.repository.GroupJpaRepository;

@Service
public class GroupService {

	@Autowired
	private GroupJpaRepository groupJpaRepository;
	
	public Group createGroup(Group group) {
		return groupJpaRepository.save(group);
	}
	
	public Group getGroup(String number) {
		return groupJpaRepository.findByNumber(number);
	}
}
