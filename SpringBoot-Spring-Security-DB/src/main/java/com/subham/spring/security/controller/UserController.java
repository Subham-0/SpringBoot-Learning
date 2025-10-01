package com.subham.spring.security.controller;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.subham.spring.security.entity.Employee;
import com.subham.spring.security.service.EmployeeImpService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private EmployeeImpService service;

    @GetMapping("/profile")
    public String profile(Principal p , Model model) {
        String email = p.getName();
        Employee employee = service.findEmployeeByEmail(email);
        model.addAttribute("employee", employee);
        return "profile"; // Thymeleaf/JSP view
    }

    @GetMapping("/home")
    public String homepage() {
        return "home";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
    
    
}
