package com.subham.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.subham.spring.entity.Employee;
import com.subham.spring.entity.Mobile;
import com.subham.spring.repository.EmpRepo;
import com.subham.spring.repository.MobileRepo;

@SpringBootApplication
public class SpringBootJpaMappingApplication implements CommandLineRunner {

	@Autowired
	MobileRepo mobilerepo;

	@Autowired
	EmpRepo empRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Mobile mobile = new Mobile();
		Employee employee = new Employee();
		
		
		
		/*
		 employee.setEmpName("subham");
		 
		//we don't need to set mobile into employee because it mapped as we mention
		//and as it mapped it will not create any column for that 
		
		mobile.setMobileName("Motorola");
		mobile.setEmployee(employee);
		
		empRepo.save(employee);
		mobilerepo.save(mobile);
		*/

		Employee e = empRepo.findById(5).get();
		System.out.println("Employee Name "+e.getEmpName());
		System.out.println("Employee Phno "+e.getMobile().getMobileName());
				
		Mobile m = mobilerepo.findById(9).get();
		System.out.println("Employee Name "+m.getEmployee().getEmpName());
		System.out.println("Employee Phno "+m.getMobileName());
		

	}

}
