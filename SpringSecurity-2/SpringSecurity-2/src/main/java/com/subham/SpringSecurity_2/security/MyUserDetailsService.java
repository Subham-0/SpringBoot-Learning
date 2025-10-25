package com.subham.SpringSecurity_2.security;

import com.subham.SpringSecurity_2.model.UserEntity;
import com.subham.SpringSecurity_2.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       UserEntity user = userRepository.findByUsername(username);
       if(user == null){
           throw new UsernameNotFoundException("User not found");
       }
       return new CustomUserPrinciple(user);
    }
}
