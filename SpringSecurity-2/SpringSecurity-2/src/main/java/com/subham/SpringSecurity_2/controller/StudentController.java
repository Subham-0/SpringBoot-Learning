package com.subham.SpringSecurity_2.controller;

import com.subham.SpringSecurity_2.model.Student;
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

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return student;
    }
}
