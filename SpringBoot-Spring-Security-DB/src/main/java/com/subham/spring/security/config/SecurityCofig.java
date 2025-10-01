package com.subham.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityCofig {

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	UserDetailsService getDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());

		return daoAuthenticationProvider;
	}
	
	@Bean
	AuthenticationSuccessHandler customSuccessHandler() {
	    return (request, response, authentication) -> {
	        var authorities = authentication.getAuthorities();

	        if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
	            response.sendRedirect("/admin/dashboard"); // Admin dashboard
	        } else {
	            response.sendRedirect("/user/profile"); // User profile
	        }
	    };
	}


	@Bean
	SecurityFilterChain getFilterChain(HttpSecurity http) throws Exception {
	    http.csrf().disable()
	        .authorizeHttpRequests()
	            // Public endpoints
	            .requestMatchers("/", "/registration", "/saveEmployee", "/signin").permitAll()

	            // Admin can access everything + admin pages
	            .requestMatchers("/admin/**").hasRole("ADMIN")
	            // User pages
	            .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN") 

	            // Any other request
	            .anyRequest().authenticated()
	        .and()
	            .formLogin()
	                .loginPage("/signin")
	                .loginProcessingUrl("/userlogin")
	                .successHandler(customSuccessHandler()) // ✅ role-based redirect
	                .permitAll()
	        .and()
	            .logout()
	                .logoutUrl("/logout")
	                .logoutSuccessUrl("/signin?logout")
	                .permitAll();

	    return http.build();
	}


}
