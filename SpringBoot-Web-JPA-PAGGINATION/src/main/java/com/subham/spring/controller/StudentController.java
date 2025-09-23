package com.subham.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.subham.spring.dto.PageResponse;
import com.subham.spring.entity.Student;
import com.subham.spring.service.StudentService;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	
	
	@GetMapping("/allstudent")
	public ResponseEntity<List<Student>> allStudent() {
	    List<Student> list = service.findAllStudent();
	    return ResponseEntity.ok(list);
	}
	
	@GetMapping("/sorted/{s}")
	public ResponseEntity<List<Student>> allSortStudent(@PathVariable String s){
		List<Student> list = service.findAllStudentwithSorting(s);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/pagesorted/{offset}/{pagesize}")
	public ResponseEntity<PageResponse> allStudentWithPage(@PathVariable int offset,@PathVariable int pagesize){
		Page<Student> pagination =  service.findAllStudentwithPage(offset,pagesize);
		 PageResponse response = new PageResponse( pagination.getSize(),pagination.getContent());
		    return ResponseEntity.ok(response);
	}
	
	@GetMapping("/pagesorted/{field}/{offset}/{pagesize}")
	public ResponseEntity<PageResponse> allSortStudentWithPage(@PathVariable String field,@PathVariable int offset,@PathVariable int pagesize){
		Page<Student> pagination =  service.findAllStudentwithPageAndSorting(field,offset,pagesize);
		 PageResponse response = new PageResponse( pagination.getSize(),pagination.getContent());
		    return ResponseEntity.ok(response);
	}


}
