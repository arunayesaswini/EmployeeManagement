package com.greatlearning.EmployeeManagementApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.greatlearning.EmployeeManagementApi.entity.MyUser;


@Repository
public interface UserRepository extends JpaRepository<MyUser,Long>{
	
	//fetching a user with user name
	@Query("SELECT u FROM MyUser u WHERE u.username=?1")
	public MyUser getUserByUsername(String username);

}
