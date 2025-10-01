package com.subham.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subham.spring.security.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {
	Employee findByEmail(String email);
}
