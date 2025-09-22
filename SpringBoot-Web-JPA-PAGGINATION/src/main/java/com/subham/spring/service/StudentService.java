package com.subham.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subham.spring.entity.Student;
import com.subham.spring.repo.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo repo;

	public List<Student> findAllStudent() {
		return repo.findAll();
	}
}
