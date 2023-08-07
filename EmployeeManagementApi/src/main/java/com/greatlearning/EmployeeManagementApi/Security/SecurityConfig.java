package com.greatlearning.EmployeeManagementApi.Security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// JDBC authentication, method chaining
		auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
				.withUser(User.withUsername("aruna").password(getPasswordEncoder().encode("aruna"))
						.roles("SUPER_ADMIN"))
				.withUser(
						User.withUsername("admin").password(getPasswordEncoder().encode("admin")).roles("ADMIN"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests().antMatchers("/users/**","/roles/**","/employees/**").hasRole("SUPER_ADMIN")
		.antMatchers("/employees/list").hasAnyRole("ADMIN", "SUPER_ADMIN","USER")
		.antMatchers("/employees/add",
				"/employees/deleteById").hasRole("ADMIN")
		.antMatchers("/employees/editById",
				"/employees/searchById",
				"/employees/searchByName",
				"/employees/sort").hasAnyRole("ADMIN", "SUPER_ADMIN","USER")		
		.antMatchers("/").permitAll()
		.and()
		.formLogin().loginProcessingUrl("/login").successForwardUrl("/employees/list")
		.and()
		.logout()
		.logoutSuccessUrl("/login")
		.permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/employees/error")
		.and()
		.cors().and().csrf().disable();
	}

//	If you don't want to encode the created password, you can write the below bean method, FYI: not recommended for Prod env
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");

	}
	
	
}
