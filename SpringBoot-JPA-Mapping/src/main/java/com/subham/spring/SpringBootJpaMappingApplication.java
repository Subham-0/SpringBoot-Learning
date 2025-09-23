package com.subham.spring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.subham.spring.entity.Address;
import com.subham.spring.entity.Employee;
import com.subham.spring.entity.Mobile;
import com.subham.spring.repository.AddressRepo;
import com.subham.spring.repository.EmpRepo;
import com.subham.spring.repository.MobileRepo;

@SpringBootApplication
public class SpringBootJpaMappingApplication implements CommandLineRunner {

	@Autowired
	MobileRepo mobilerepo;

	@Autowired
	EmpRepo empRepo;
	
	@Autowired
	AddressRepo addressRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		//One-to-one
		
		/*
		  Mobile mobile = new Mobile();
		  Employee employee = new Employee();
		
		 employee.setEmpName("subham");
		 
		//we don't need to set mobile into employee because it mapped as we mention
		//and as it mapped it will not create any column for that 
		
		mobile.setMobileName("Motorola");
		mobile.setEmployee(employee);
		
		empRepo.save(employee);
		mobilerepo.save(mobile);
		
		Employee e = empRepo.findById(5).get();
		System.out.println("Employee Name "+e.getEmpName());
		System.out.println("Employee Phno "+e.getMobile().getMobileName());
				
		Mobile m = mobilerepo.findById(9).get();
		System.out.println("Employee Name "+m.getEmployee().getEmpName());
		System.out.println("Employee Phno "+m.getMobileName());
		
		*/
		
		
		//One-to-many and Many-to-one
		/*
		Employee employee = new Employee();
		employee.setEmpName("Abhishek");

		Address address1 = new Address();
		address1.setType("home");
		address1.setAddress("xyz,Bihar");
		address1.setEmployee(employee);
		
		Address address2 = new Address();
		address2.setType("Office");
		address2.setAddress("xyz,Jharkhand");
		address2.setEmployee(employee);
		
		List<Address> address = new ArrayList<>();
		address.add(address1);
		address.add(address2);
		
		employee.setAddress(address);
		
		
		empRepo.save(employee);
		addressRepo.save(address1);
		addressRepo.save(address2);
		*/
		
		/*
		Employee e = empRepo.findById(6).get();
		System.out.println("Employee name : " + e.getEmpName());
		List<Address> addresses = e.getAddress();
		
		addresses.forEach((a)->{
			System.out.println("Address : "+a.getAddress()+" , "+a.getType());
		});
	
		Address address = addressRepo.findById(2).get();
		System.out.println("Employee name : "+address.getEmployee().getEmpName());
		System.out.println("Employee address : "+address.toString());
		*/
		
		//many-to-many
		

	}

}
