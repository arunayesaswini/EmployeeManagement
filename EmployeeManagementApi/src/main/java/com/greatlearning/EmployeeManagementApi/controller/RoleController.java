package com.greatlearning.EmployeeManagementApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagementApi.entity.Role;
import com.greatlearning.EmployeeManagementApi.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleService;

	// creating a new role
	@PostMapping("/add")
	public Role createRole(Role role) {
		return roleService.addRole(role);
	}

	// creating multiple roles
	@PostMapping("/addMultiple")
	public String addAllRoles(List<Role> roles) {
		return roleService.addAllRoles(roles);
	}

	// updating role by Role Id
	@PutMapping("/editById")
	public Role updateRole(@RequestParam("id") long rid, @RequestBody Role role) {
		return roleService.updateRole(rid, role);

	}

	// Getting Role details using Role Id
	@GetMapping("/searchById")
	public Role getRolebyID(@RequestParam("id") long rid) {
		return roleService.getRoleById(rid);
	}

	@GetMapping("/searchByName")
	public Role getRoleByName(@RequestParam("name") String rname) {
		return roleService.getRoleByName(rname);
	}

	// Listing roles present in Database
	@GetMapping("/list")
	public List<Role> getAllRoles() {
		return roleService.getAllRoles();
	}

	// Delete Role by Id
	@DeleteMapping("/delete")
	public String deleteRoleById(@RequestParam("id") long rid) {
		return roleService.deleteRole(rid);
	}

	// Delete Role by Name
	@DeleteMapping("/delete")
	public String deleteRoleByName(@RequestParam("name") String rname) {
		return roleService.deleteRole(rname);
	}

}
