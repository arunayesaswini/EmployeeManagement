package com.greatlearning.EmployeeManagementApi.Security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.EmployeeManagementApi.entity.Role;
import com.greatlearning.EmployeeManagementApi.service.RoleService;
import com.greatlearning.EmployeeManagementApi.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{

	 @Autowired
	    private UserService userService;
	    
	    @Autowired
	    private RoleService roleService;

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	            .antMatchers("/users/**","/roles/**").hasRole("ADMIN")
	            .antMatchers("/users/**").hasAnyRole("USER", "ADMIN")
	            .anyRequest().authenticated()
	            .and()
	            .formLogin()
	            .and()
	            .logout().permitAll();
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	    }

	    @Bean
	    public UserDetailsService userDetailsService() {
	    	
	        return username -> userService.getUserByName(username);
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return NoOpPasswordEncoder.getInstance();
	    }

	    @PostConstruct
	    public void init() {
	        // Dynamically create roles if not already present
	        Role adminRole = roleService.getRoleByName("ADMIN");
	        if (adminRole == null) {
	            roleService.addRole("ADMIN");
	        }
	
}