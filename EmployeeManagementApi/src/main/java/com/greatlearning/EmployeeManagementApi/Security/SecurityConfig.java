package com.greatlearning.EmployeeManagementApi.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.greatlearning.EmployeeManagementApi.serviceImpl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
	@Bean
	public DaoAuthenticationProvider myAuthProvider()
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(myUserDetails());
		provider.setPasswordEncoder(getPasswordEncoder());
		return provider;
	}
	
	@Bean
	public UserDetailsService myUserDetails() {
		
		return (new UserDetailsServiceImpl());
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}

	/*
	 * //excluding security for H2 Console
	 * 
	 * @Override public void configure(WebSecurity web) throws Exception {
	 * web.ignoring().antMatchers("/h2-console/**"); }
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		http
		.authorizeRequests()
		.antMatchers("/users/**","/roles/**").hasAuthority("ROLE_ADMIN")
		.antMatchers("/employees/add","/employees/delete").hasRole("ADMIN")
		.antMatchers(
				"/employees/list",
				"/employees/editById",
				"/employees/searchById",
				"/employees/searchByName",
				"/employees/sort"
				).hasAnyRole("STAFF","ADMIN")
		.antMatchers(
				"/employees/list",
				"/employees/searchById",
				"/employees/searchByName",
				"/employees/sort"
				).hasRole("USER")
		.and()
		.formLogin().loginProcessingUrl("/login").successForwardUrl("/employees/list").permitAll()
		.and()
		.logout().logoutSuccessUrl("/login").permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error")
		.and()
		.cors().and().csrf().disable();
		
		http.authenticationProvider(myAuthProvider());
		
		return http.build();	
		
	}
	
	
	
	
	
}