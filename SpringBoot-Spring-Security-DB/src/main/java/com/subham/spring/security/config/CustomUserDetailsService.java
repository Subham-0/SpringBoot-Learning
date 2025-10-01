package com.subham.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.subham.spring.security.entity.Employee;
import com.subham.spring.security.repository.EmpRepo;

@Component
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private EmpRepo empRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee emp = empRepo.findByEmail(username);
		if(emp == null) {
			throw new UsernameNotFoundException("user name not found");
		}
		else {
			return new CustomUser(emp);
		}
	}

}
