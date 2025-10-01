package com.subham.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
	

	@GetMapping("/home")
	public String homepage() {	
		return "home";
	}
	
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	
	@GetMapping("/about")
	public String aboutPage() {
		return "about";
	}

	@GetMapping("/signin")
	public String signin() {
		return "login";
	}

	@GetMapping("/invalid")
	public String invalid() {
		return "error";
	}

	@GetMapping("/userlogout")
	public String logout() {
		return "logout";
	}
}
