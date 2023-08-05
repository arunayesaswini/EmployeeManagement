package com.greatlearning.EmployeeManagementApi.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementApi.entity.Employee;

@Service
public interface EmployeeService {

	// Adding an Employee
	Employee addEmployee(Employee emp);

	// Updating Employee Details using Employee Id
	Employee updateEmployee(long eid, Employee emp);

	// Fetching Employee Details using Employee Id
	Employee getEmployee(long eid);

	// Fetching all Employees Details
	List<Employee> getAllEmployees();

	// Deleting an Employee based on Employee Id
	String deleteEmployee(long eid);

	// Fetching Employees based on First Name.
	// If found more than one will list Employee Details
	// having the given name as First Name
	List<Employee> getEmployeeByName(String fname);

	// Fetching Employees in sorted order using Employee first name
	List<Employee> sortEmployeeByFirstName(String order);
}
