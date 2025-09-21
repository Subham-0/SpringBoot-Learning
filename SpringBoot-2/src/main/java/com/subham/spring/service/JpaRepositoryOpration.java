package com.subham.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.subham.spring.SpringBoot2Application;
import com.subham.spring.entity.Student;
import com.subham.spring.repo.StudentJpaRepository;

@Service
public class JpaRepositoryOpration {

	private final SpringBoot2Application springBoot2Application;

	@Autowired
	StudentJpaRepository repository;

	JpaRepositoryOpration(SpringBoot2Application springBoot2Application) {
		this.springBoot2Application = springBoot2Application;
	}

	public void findByName(String name) {
		Student stud = repository.findByName(name);
		System.out.println(stud);
	}

	public void findByAddress(String address) {
		Student stud = repository.findByAddress(address);
		System.out.println(stud);
	}

	public void findByNameAndAddress(String name, String address) {
		Student stud = repository.findByNameAndAddress(name, address);
		System.out.println(stud);
	}

	public void findByNameOrAddress(String name, String address) {
		List<Student> students = repository.findByNameOrAddress(name, address);
		students.forEach((e) -> {
			System.out.println(e);
		});

	}

	public void findByAddressIsNull() {
		List<Student> students = repository.findByAddressIsNull();
		students.forEach((e) -> {
			System.out.println(e);
		});

	}

	public void findByAddressIsNotNull() {
		List<Student> students = repository.findByAddressIsNotNull();
		students.forEach((e) -> {
			System.out.println(e);
		});

	}

	public void findByNameLike(String name) {
		List<Student> students = repository.findByNameLike(name);
		students.forEach((e) -> {
			System.out.println(e);
		});

	}

	public void findByNameStartingWith(String name) {
		List<Student> students = repository.findByNameStartingWith(name);
		students.forEach((e) -> {
			System.out.println(e);
		});

	}

	public void findByNameContaining(String name) {
		List<Student> students = repository.findByNameContaining(name);
		students.forEach((e) -> {
			System.out.println(e);
		});

	}

	public void findByOrderByNameDesc() {
		List<Student> students = repository.findByOrderByNameDesc();
		students.forEach((e) -> {
			System.out.println(e);
		});

	}

	public void existsByName(String name) {
		System.out.println(repository.existsByName(name));
		
	}

	public void existsByAllIgnoreCaseName(String name) {
	System.out.println(repository.existsByNameIgnoreCase(name));
		
	}

	public void existsByIgnoreCaseAddress(String address) {
		System.out.println(repository.existsByAddressIgnoreCase(address));
		
	}

	public void getStudentByNameOrAddress(String name, String address) {
		List<Student> students = repository.getStudentByNameOrAddress(name, address);
		students.forEach((e) -> {
			System.out.println(e);
		});
	}
	
	public void getStudentByNameAndAddress(String name, String address) {
		Student s = repository.getStudentByNameAndAddress(name, address);
		System.out.println(s);
	}

	public void searchByName(String name) {
		List<Student> students = repository.searchByName(name);
		students.forEach((e) -> {
			System.out.println(e);
		});
	}
}
