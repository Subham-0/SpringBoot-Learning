package com.subham.spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.subham.spring.security.entity.Employee;
import com.subham.spring.security.service.EmployeeService;
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "admin-dashboard";
    }

    @GetMapping("/view-all")
    public String viewAllEmployees(Model model) {
        List<Employee> employees = service.getAllEmployees();
        model.addAttribute("employees", employees);
        return "view-all";
    }
}
