package com.greatlearning.EmployeeManagementApi.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@PostMapping("/addEmployee")
	public String addEmployee()
	{
		return "";
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee()
	{
		return "";
	}
	
	@GetMapping("/getEmployeeById")
	public String getEmployeeById()
	{
		return "";
	}
	
	@DeleteMapping("/deleteEmployeeById")
	public String deleteEmployeeById()
	{
		return "";
		
	}
	

}
