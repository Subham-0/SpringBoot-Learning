package com.subham.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	
	public List<Student> findAllStudentwithSorting(String field){
		return repo.findAll(Sort.by(Direction.ASC ,field));
	}
	
	public Page<Student> findAllStudentwithPage(int offset,int pagesize){
		return repo.findAll(PageRequest.of(offset, pagesize));
	}
}
