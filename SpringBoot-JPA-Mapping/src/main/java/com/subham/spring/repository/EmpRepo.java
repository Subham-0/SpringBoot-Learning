package com.subham.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subham.spring.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
