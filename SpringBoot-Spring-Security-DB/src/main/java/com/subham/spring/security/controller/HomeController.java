package com.subham.spring.security.controller;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.subham.spring.security.entity.Employee;
import com.subham.spring.security.service.EmployeeImpService;


@Controller
public class HomeController {

	
	private final EmployeeImpService service;
	private final PasswordEncoder passwordEncoder;
	
	public HomeController(EmployeeImpService service, PasswordEncoder passwordEncoder) {
		super();
		this.service = service;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/")
	public String indexPage() {
		return "index";
	}

	@GetMapping("/registration")
	public String registrationPage(Model model) {
		model.addAttribute("employee", new Employee());
		return "registration";
	}

	@GetMapping("/invalid")
	public String invalid() {
		return "error";
	}

	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}

	@GetMapping("/signin")
	public String signin() {
		return "login";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee) {

		employee.setRole("ROLE_USER");
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));

//		System.out.println(employee);
		service.saveEmployee(employee);

		 return "redirect:/signin?registered";
	}

}

	

	