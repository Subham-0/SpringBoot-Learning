package com.subham.SpringSecurity.controller;

import com.subham.SpringSecurity.entity.User;
import com.subham.SpringSecurity.repository.UserRepository;
import com.subham.SpringSecurity.sevice.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
//        userRepository.save(user);
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){

         return userService.verify(user);

//        var u =  userRepository.findByUserName(user.getUserName());
//        if(!Objects.isNull(u))
//            return ResponseEntity.ok("success");
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}
