package com.greatlearning.EmployeeManagementApi.controller;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagementApi.entity.Employee;
import com.greatlearning.EmployeeManagementApi.service.EmployeeService;

@RestController
public class EmployeeController {
	
	EmployeeService empService;
	
	//create Employee
	@PostMapping("/addEmployee")
	public Employee addEmployee(Employee employee)
	{
		return empService.addEmployee(employee) ;
	}

	//update Employee with given Updated JSON Object
	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestParam("id") long id,
			@RequestBody Employee emp)
	{
		return empService.updateEmployee(id, emp);
	}
	
	//get an Employee Details using Employee Id
	@GetMapping("/getEmployeeById")
	public Employee getEmployeeById(@RequestParam("id") long id)
	{
		return empService.getEmployee(id);
	}
	
	//get all Employees Details
	@GetMapping("/listEmployees")
	public List<Employee> getAllEmployees()
	{
		return empService.getAllEmployees();
	}
	
	//Deleting an Employee using Employee Id
	@DeleteMapping("/deleteEmployeeById")
	public String deleteEmployeeById(@RequestParam("id") long id)
	{
		return empService.deleteEmployee(id);
		
	}
	
	@GetMapping("/searchEmployeeByName")
	public List<Employee> searchEmployeeByName(@RequestParam("firstName") String fname)
	{
		return empService.getEmployeeByName(fname);
	}
	
	@GetMapping("/sortEmployees")
	public List<Employee> sortEmployees(@RequestParam(defaultValue="asc") String order)
	{
		return empService.sortEmployeeByFirstName(order);
		
	}
	

}
