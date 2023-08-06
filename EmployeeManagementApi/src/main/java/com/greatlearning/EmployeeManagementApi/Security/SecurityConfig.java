package com.greatlearning.EmployeeManagementApi.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.greatlearning.EmployeeManagementApi.serviceImpl.UserDetailsServiceImpl;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	public DaoAuthenticationProvider myAuthenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(myUser());
		daoAuthenticationProvider.setPasswordEncoder(myPassword());
		
		return daoAuthenticationProvider;
	}
	
	//This is for not encrypting the password
	@Bean
	private PasswordEncoder myPassword() {
		
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public UserDetailsService myUser()
	{
		return(new UserDetailsServiceImpl());
		
	}
	
		
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/users","/roles").hasAuthority("SUPER_ADMIN")
		.antMatchers("/employees").hasAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginProcessingUrl("/login").successForwardUrl("/employee/list")
		.and()
		.logout().logoutSuccessUrl("/login").permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/employees/error")
		.and()
		.cors().and().csrf().disable();
		
		
		return http.build();
    }

}
