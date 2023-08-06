package com.greatlearning.EmployeeManagementApi.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagementApi.entity.Employee;
import com.greatlearning.EmployeeManagementApi.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	EmployeeService empService;

	// create Employee
	@PostMapping("/add")
	public Employee addEmployee(Employee employee) {
		return empService.addEmployee(employee);
	}

	// update Employee with given Updated JSON Object
	@PutMapping("/editById")
	public Employee updateEmployee(@RequestParam("id") long id, @RequestBody Employee emp) {
		return empService.updateEmployee(id, emp);
	}

	// search Employee Details using by Employee Id
	@GetMapping("/searchById")
	public Employee getEmployeeById(@RequestParam("id") long id) {
		return empService.getEmployee(id);
	}

	// search Employee Details using by Employee Name
	@GetMapping("/searchByName")
	public List<Employee> searchEmployeeByName(@RequestParam("firstName") String fname) {
		return empService.getEmployeeByName(fname);
	}

	// List all Employees
	@GetMapping("/list")
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}

	// Sorting Employees by first name using descending or ascending order
	@GetMapping("/sort")
	public List<Employee> sortEmployees(@RequestParam(defaultValue = "asc") String order) {
		return empService.sortEmployeeByFirstName(order);

	}

	// Deleting an Employee using Employee Id
	@DeleteMapping("/deleteById")
	public String deleteEmployeeById(@RequestParam("id") long id) {
		return empService.deleteEmployee(id);

	}

	// Handling Error Page
	@RequestMapping("/error")
	public String accessDenied(Principal user) {
		if (user != null) {
			return user.getName() + " You donot have permission to access this page";
		} else
			return "You donot have permission to access this page";
	}

}
