package com.greatlearning.EmployeeManagementApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementApi.entity.Role;
import com.greatlearning.EmployeeManagementApi.repository.RoleRepository;
import com.greatlearning.EmployeeManagementApi.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	// Storing role in Database using saveAndFlush method
	@Override
	public Role addRole(String rname) {
		Role role=new Role();
		role.setName(rname);
		return roleRepository.saveAndFlush(role);
	}
	
	// Fetching Role by Id
	@Override
	public Role getRoleById(Long rid) {

		return roleRepository.findById(rid).get();
	}

	// Fetching Role by Name
	@Override
	public Role getRoleByName(String rname) {

		return roleRepository.findByName(rname);
	}

	// Updating Role by Id
	@Override
	public Role updateRole(Long rid, Role role) {
		Role role_db = getRoleById(rid);
		role_db.setName(role.getName());
		return roleRepository.save(role_db);
	}

	// Deleting Role by Id
	@Override
	public String deleteRole(Long rid) {
		roleRepository.deleteById(rid);
		return "Role deleted";
	}

	// Deleting Role by Name
	@Override
	public String deleteRole(String rname) {
		Role delete_role = getRoleByName(rname);
		roleRepository.delete(delete_role);
		return "Role deleted";
	}

	// Fetching all Roles in DataBase
	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	
	

}
