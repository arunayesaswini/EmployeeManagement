package com.greatlearning.EmployeeManagementApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementApi.entity.Role;

@Service
public interface RoleService {

	// creating a single Role
	Role addRole(Role role);

	// creating multiple Roles at a time
	String addAllRoles(List<Role> roles);

	// fetch role by id
	Role getRoleById(Long rid);

	// fetch role by name
	Role getRoleByName(String rname);

	// fetch all Roles in Database
	List<Role> getAllRoles();

	// Edit Role by Id
	Role updateRole(Long rid, Role role);

	// Delete Role by Id
	String deleteRole(Long rid);

	// Delete Role by Name
	String deleteRole(String rname);
}
