package com.greatlearning.EmployeeManagementApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.EmployeeManagementApi.entity.User;
import com.greatlearning.EmployeeManagementApi.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	// Adding single user
	@PostMapping("/add")
	public User addUser(User user) {
		return userService.addUser(user);
	}

	// Adding Multiple Users
	@PostMapping("/addMultiple")
	public String addMulitpleUsers(List<User> users) {
		return userService.addAllUsers(users);
	}

	// Fetching User by Id
	@GetMapping("/searchById")
	public User searchUserById(@RequestParam("id") long uid) {
		return userService.getUserById(uid);
	}

	// Fetching User by Id
	@GetMapping("/searchByName")
	public User searchUserByName(@RequestParam("username") String uname) {
		return userService.getUserByName(uname);
	}

	// Listing all Users
	@GetMapping("/list")
	public List<User> listAllUsers() {
		return userService.getAllUsers();
	}

	// Editing User details by Id
	@PutMapping("/editById")
	public User editUser(@RequestParam("id") long uid, @RequestBody User user) {
		return userService.updateUser(uid, user);
	}

	// Deleting User by Id
	@DeleteMapping("/delete")
	public String deleteUser(@RequestParam("id") long uid) {
		return userService.deleteUser(uid);
	}

	// Delete User by Name
	@DeleteMapping("/delete")
	public String deletUser(@RequestParam("username") String uname) {
		return userService.deleteUser(uname);
	}

}
