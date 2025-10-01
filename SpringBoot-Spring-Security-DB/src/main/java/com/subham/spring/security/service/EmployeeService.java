package com.subham.spring.security.service;

import java.util.List;

import com.subham.spring.security.entity.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployees();

}
