package com.subham.SpringSecurity_2.service;

import com.subham.SpringSecurity_2.model.UserEntity;
import com.subham.SpringSecurity_2.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    public UserEntity register(UserEntity user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
