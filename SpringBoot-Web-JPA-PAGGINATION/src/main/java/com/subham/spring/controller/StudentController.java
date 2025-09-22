package com.subham.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subham.spring.entity.Student;
import com.subham.spring.service.StudentService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostConstruct
	public void init() {
	    System.out.println("StudentController loaded...");
	}
	
	@GetMapping("/allstudent")
	public ResponseEntity<List<Student>> allStudent() {
	    List<Student> list = service.findAllStudent();
	    System.out.println("hello");
	    return ResponseEntity.ok(list); 
	}


}
