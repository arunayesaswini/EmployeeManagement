package com.greatlearning.EmployeeManagementApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementApi.entity.MyUser;
import com.greatlearning.EmployeeManagementApi.repository.UserRepository;
import com.greatlearning.EmployeeManagementApi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	// adding user to database
	@Override
	public MyUser addUser(MyUser user) {

		return userRepository.saveAndFlush(user);
	}

	// fetching user by Id
	@Override
	public MyUser getUserById(Long uid) {

		return userRepository.findById(uid).get();
	}

	// fetching user by user name
	@Override
	public MyUser getUserByName(String uname) {

		return userRepository.getUserByUsername(uname);
	}

	// fetching all users in database
	@Override
	public List<MyUser> getAllUsers() {

		return userRepository.findAll();
	}

	// updating user using user id
	@Override
	public MyUser updateUser(Long uid, MyUser user) {
		MyUser user_db = getUserById(uid);
		user_db.setUsername(user.getUsername());
		user_db.setPassword(user.getUsername());

		return userRepository.save(user_db);
	}

	// Deleting user by user id
	@Override
	public String deleteUser(Long uid) {
		userRepository.deleteById(uid);
		return "User Deleted";
	}

	// Deleting user by user name
	@Override
	public String deleteUser(String uname) {
		MyUser user_delete = getUserByName(uname);
		userRepository.delete(user_delete);
		return "User Deleted";
	}
}
