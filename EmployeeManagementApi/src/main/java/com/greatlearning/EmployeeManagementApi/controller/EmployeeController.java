package com.greatlearning.EmployeeManagementApi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagementApi.entity.Employee;

@RestController
public class EmployeeController {
	
	//create Employee
	@PostMapping("/addEmployee")
	public String addEmployee()
	{
		return "";
	}
	
	//update Employee with given Updated JSON Object
	@PutMapping("/updateEmployee")
	public String updateEmployee()
	{
		return "";
	}
	
	//get an Employee Details using Employee Id
	@GetMapping("/getEmployeeById")
	public String getEmployeeById()
	{
		return "";
	}
	
	//get all Employees Details
	@GetMapping("/listEmployees")
	public List<Employee> getAllEmployees()
	{
		return null;
	}
	
	//Deleting an Employee using Employee Id
	@DeleteMapping("/deleteEmployeeById")
	public String deleteEmployeeById()
	{
		return "";
		
	}
	

}
