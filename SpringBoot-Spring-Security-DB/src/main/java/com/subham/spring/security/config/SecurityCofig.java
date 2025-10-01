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
	SecurityFilterChain getFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests().requestMatchers("/").permitAll()
		.anyRequest().authenticated()
				.and().formLogin().loginPage("/signin")
				.loginProcessingUrl("/userlogin")
				.defaultSuccessUrl("/about").permitAll()
				//.failureUrl("/invalid")
				.and()
				.logout().logoutSuccessUrl("/userlogout")
				
				.permitAll();

		return http.build();
	
	}

}
