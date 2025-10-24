package com.subham.SpringSecurity_2.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HomeController{
    @GetMapping("/")
    public String home(HttpServletRequest request){
        return "welcome to home "+ request.getSession().getId();
    }
}
