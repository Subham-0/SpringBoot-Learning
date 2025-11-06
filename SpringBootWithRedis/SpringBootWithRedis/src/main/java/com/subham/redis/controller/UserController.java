package com.subham.redis.controller;

import com.subham.redis.dao.UserDao;
import com.subham.redis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userDao.save(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        return userDao.get(userId);
    }

    @GetMapping()
    public List<User> getAll() {
//        return userDao.findAll();
        Map<Object, Object> all = userDao.findAll();
        Collection<Object> values = all.values();
        List<User> allUsers = values.stream().map(value -> (User) value).collect(Collectors.toList());
        return allUsers;
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody User updatedUser) {
        // Get existing user
        User existingUser = userDao.get(userId);
        if (existingUser == null) {
            throw new RuntimeException("User not found with ID: " + userId);
        }

        // Update the fields you want (you can control what gets updated)
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhone(updatedUser.getPhone());

        return userDao.update(existingUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userDao.delete(userId);

    }

}
