package com.subham.spring.security.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.subham.spring.security.entity.Employee;

public class CustomUser implements UserDetails {

	private Employee employee;

	public CustomUser(Employee employee) {
		super();
		this.employee = employee;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(employee.getRole());
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return employee.getPassword();

	}

	@Override
	public String getUsername() {
		return employee.getEmail();
	}

}
