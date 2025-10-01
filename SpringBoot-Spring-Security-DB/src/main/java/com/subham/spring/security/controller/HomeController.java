package com.subham.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
	

	@GetMapping("/")
	public String homepage() {	
		return "home";
	}
	
	@GetMapping("/index")
	public String indexPage() {
		return "index";
	}
	
	@GetMapping("/about")
	public String aboutPage() {
		return "about";
	}

}
