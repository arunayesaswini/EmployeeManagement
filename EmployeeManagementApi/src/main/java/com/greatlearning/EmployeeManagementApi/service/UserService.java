package com.greatlearning.EmployeeManagementApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementApi.entity.User;

@Service
public interface UserService {

	// creating a single user
	User addUser(User user);

	// fetch user by id
	User getUserById(Long uid);

	// fetch user by name
	User getUserByName(String uname);

	// fetch all users in Database
	List<User> getAllUsers();

	// Edit User by Id
	User updateUser(Long uid, User user);

	// Delete User by Id
	String deleteUser(Long uid);

	// Delete Role by Name
	String deleteUser(String uname);
	
	//finding for duplication
	String isUserNameExist(String uname);

}
