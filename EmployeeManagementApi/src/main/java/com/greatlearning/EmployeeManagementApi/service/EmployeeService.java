package com.greatlearning.EmployeeManagementApi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementApi.entity.Employee;

@Service
public interface EmployeeService {

	Employee addEmployee(Employee emp);
	Employee updateEmployee(long eid,Employee emp);
	Employee getEmployee(long eid);
	List<Employee> getAllEmployees();
	void deleteEmployee(int eid);
	
}
