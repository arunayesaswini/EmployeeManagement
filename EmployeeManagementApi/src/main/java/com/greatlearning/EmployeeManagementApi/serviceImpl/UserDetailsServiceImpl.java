package com.greatlearning.EmployeeManagementApi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.greatlearning.EmployeeManagementApi.Security.MyUserAuthenticationDetails;
import com.greatlearning.EmployeeManagementApi.entity.MyUser;
import com.greatlearning.EmployeeManagementApi.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		MyUser myUser=userRepository.findByUsername(username);
		if(myUser==null)
			throw new UsernameNotFoundException("Could not find user");
		return new MyUserAuthenticationDetails(myUser);
	}

}
