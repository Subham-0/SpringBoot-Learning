package com.subham.spring.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subham.spring.security.entity.Employee;
import com.subham.spring.security.repository.EmpRepo;

@Service
public class EmployeeImpService implements EmployeeService {

	@Autowired
	private EmpRepo empRepo;

	@Override
	public Employee saveEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	public Employee findEmployeeByEmail(String s) {
		return empRepo.findByEmail(s);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

}
