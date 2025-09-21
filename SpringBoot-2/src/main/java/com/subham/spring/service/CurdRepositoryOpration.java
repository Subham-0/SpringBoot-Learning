package com.subham.spring.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subham.spring.entity.Student;
import com.subham.spring.exception.StudentNotFoundException;
import com.subham.spring.repo.StudentRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class CurdRepositoryOpration {

	@Autowired
	StudentRepository repository;

	@PersistenceContext
	EntityManager entityManager;

	public void testSave() {
		Student student = new Student();
		student.setName("Rajib");
		student.setAddress("Baleswar");
		repository.save(student);
	}

//	saveAll() with batch processing
//	we can set how many operation we want to do in each batch (in properties[batch_size=20])
	@Transactional
	public void testSaveAll() {
		List<Student> students = new ArrayList<Student>();
		for (int i = 0; i <= 130; i++) {
			Student stud = new Student();
			stud.setName("Name" + i);
			stud.setAddress(i + "Address");
			students.add(stud);
		}
//			repository.saveAll(students);
		for (int i = 0; i <= 130; i++) {
			repository.save(students.get(i));
			if (i % 50 == 0) {
				entityManager.flush();
				entityManager.clear();
				System.out.println("flush and clear working");
			}
		}
		entityManager.flush();
		entityManager.clear();
		System.out.println("flush and clear working");
	}

	public void testfindAll() {
		List<Student> students = new ArrayList<Student>();
		students = (List<Student>) repository.findAll();

		students.forEach(s -> {
			System.out.println(s);
		});
	}

	public void testfindAllById() {
		List<Integer> id = new ArrayList<>(Arrays.asList(300, 400, 421, 365));

		List<Student> students = new ArrayList<Student>();

		students = (List<Student>) repository.findAllById(id);
		students.forEach(s -> {
			System.out.println(s);
		});
	}

	public void testFindById() {
		Optional<Student> s = repository.findById(345);
		System.out.println(s);
	}

	public void testExistsById() {
		boolean res = repository.existsById(23);
		System.out.println(res);
	}

	public void testCount() {
		long i = repository.count();
		System.out.println(i);
	}

	public void testDelete(int id) {
		Student s = repository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("student with id " + id + " not found"));
		repository.delete(s);
		System.out.println("student with id " + id + " successfully deleted");
	}

	public void testDeleteAllById() {
		List<Integer> ids = new ArrayList<>(Arrays.asList(300, 400, 421, 365, 432));
		List<Student> students = new ArrayList<Student>();
		students = (List<Student>) repository.findAllById(ids);
		if (ids.size() != students.size()) {
			List<Integer> foundIds = students.stream().map(stud -> stud.getId()).toList();
			List<Integer> missingIds = ids.stream().filter(id -> !foundIds.contains(id)).toList();
			throw new StudentNotFoundException("Students not found with IDs: " + missingIds);
		}
		repository.deleteAllById(ids);
	}
	public void testDeleteAll() {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(240,"Address3","Name3"));
		students.add(new Student(241,"Address4","Name4"));
		students.add(new Student(242,"Address5","Name5"));
		List<Integer> missingsIds = new ArrayList<Integer>();
		students.forEach((s)->{
			if(!repository.existsById(s.getId())) {
				missingsIds.add(s.getId());
			}
		});
		if(!missingsIds.isEmpty()) {
			throw new StudentNotFoundException("Students not found with IDs: " + missingsIds);
		}
		repository.deleteAll(students);
		
	}
}
