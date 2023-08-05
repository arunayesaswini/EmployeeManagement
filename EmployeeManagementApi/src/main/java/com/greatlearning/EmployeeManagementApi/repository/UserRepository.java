package com.greatlearning.EmployeeManagementApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.greatlearning.EmployeeManagementApi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	//fetching a user with user name
	@Query("SELECT u FROM User u WHERE u.username=?1")
	public User findUserByUsername(String username);

}
