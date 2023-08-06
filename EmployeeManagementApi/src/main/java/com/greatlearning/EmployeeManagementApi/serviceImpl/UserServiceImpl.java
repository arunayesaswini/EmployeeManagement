package com.greatlearning.EmployeeManagementApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementApi.entity.User;
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
	public User addUser(User user) {

		return userRepository.saveAndFlush(user);
	}

	// fetching user by Id
	@Override
	public User getUserById(Long uid) {

		return userRepository.findById(uid).get();
	}

	// fetching user by user name
	@Override
	public User getUserByName(String uname) {

		return userRepository.findUserByUsername(uname);
	}

	// fetching all users in database
	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}

	// updating user using user id
	@Override
	public User updateUser(Long uid, User user) {
		User user_db = getUserById(uid);
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
		User user_delete = getUserByName(uname);
		userRepository.delete(user_delete);
		return "User Deleted";
	}

	@Override
	public  String isUserNameExist(String uname) {
		String sql="SELECT COUNT(*) FROM User WHERE username=?";
		return jdbcTemplate.queryForObject(sql, new Object[] {uname},String.class);
	}

}
