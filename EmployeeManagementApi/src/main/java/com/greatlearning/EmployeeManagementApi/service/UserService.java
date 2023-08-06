package com.greatlearning.EmployeeManagementApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementApi.entity.MyUser;

@Service
public interface UserService {

	// creating a single user
	MyUser addUser(MyUser user);

	// fetch user by id
	MyUser getUserById(Long uid);

	// fetch user by name
	MyUser getUserByName(String uname);

	// fetch all users in Database
	List<MyUser> getAllUsers();

	// Edit User by Id
	MyUser updateUser(Long uid, MyUser user);

	// Delete User by Id
	String deleteUser(Long uid);

	// Delete Role by Name
	String deleteUser(String uname);

}
