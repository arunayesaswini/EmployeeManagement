package com.greatlearning.EmployeeManagementApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.greatlearning.EmployeeManagementApi.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

	//fetching a role with given name
	@Query("SELECT r ROLE r WHERE r.name=?1")
	public Role findByName(String rname);
	

}
