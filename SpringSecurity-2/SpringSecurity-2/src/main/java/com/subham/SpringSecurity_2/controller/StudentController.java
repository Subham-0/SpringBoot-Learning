package com.subham.SpringSecurity_2.controller;

import com.subham.SpringSecurity_2.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    List<Student> studentList = new ArrayList<>(List.of(
            new Student(1,"subham",87),
            new Student(2,"raja",98)
    ));

    @GetMapping("/all")
    public List<Student> getAllStudent(){
        return studentList;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return student;
    }
}
