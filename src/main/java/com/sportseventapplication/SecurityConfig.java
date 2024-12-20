package com.sportseventapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.sportseventapplication.auth.service.JWTService;
import com.sportseventapplication.auth.service.MyJwtFilter;
import com.sportseventapplication.auth.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private MyUserDetailsService details;
	@Autowired
	private JWTService jwtService;
	
	@Bean
	public SecurityFilterChain security(HttpSecurity http) throws Exception {
		return http
				.csrf(c->c.disable())
				.cors(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults())
				.addFilterBefore(new MyJwtFilter(jwtService), BasicAuthenticationFilter.class)

				.httpBasic(Customizer.withDefaults())
				.authorizeHttpRequests(request->request.requestMatchers("/users/register","users/login").permitAll().anyRequest().authenticated())
				.build();
	}
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(details);
		return provider;
		
	}
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
	   return	http
			   .getSharedObject(AuthenticationManagerBuilder.class)
			   .authenticationProvider(authenticationProvider())
			   .build();
		
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		return new BCryptPasswordEncoder();
	}
	
	
	
}