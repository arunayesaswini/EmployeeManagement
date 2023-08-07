package com.greatlearning.EmployeeManagementApi.controller;

import java.security.Principal;
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

import com.greatlearning.EmployeeManagementApi.entity.MyUser;
import com.greatlearning.EmployeeManagementApi.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	// Adding single user
	@PostMapping("/add")
	public MyUser addUser(MyUser user) {
		return userService.getUserByName(user.getUsername());
	}

	// Fetching User by Id
	@GetMapping("/searchById")
	public MyUser searchUserById(@RequestParam("id") long uid) {
		return userService.getUserById(uid);
	}

	// Fetching User by Id
	@GetMapping("/searchByName")
	public MyUser searchUserByName(@RequestParam("username") String uname) {
		return userService.getUserByName(uname);
	}

	// Listing all Users
	@GetMapping("/list")
	public List<MyUser> listAllUsers() {
		return userService.getAllUsers();
	}

	// Editing User details by Id
	@PutMapping("/editById")
	public MyUser editUser(@RequestParam("id") long uid, @RequestBody MyUser user) {
		return userService.updateUser(uid, user);
	}

	// Deleting User by Id
	@DeleteMapping("/deleteById")
	public String deleteUserById(@RequestParam("id") long uid) {
		return userService.deleteUser(uid);
	}

	// Delete User by Name
	@DeleteMapping("/deleteByName")
	public String deletUserByName(@RequestParam("username") String uname) {
		return userService.deleteUser(uname);
	}

	// Handling Error Page
	@RequestMapping("/error")
	public String accessDenied(Principal user) {
		if (user != null) {
			return user.getName() + " You donot have permission to access this page";
		} else
			return "You donot have permission to access this page";
	}

}
