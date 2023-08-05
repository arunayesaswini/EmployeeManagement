package com.greatlearning.EmployeeManagementApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.EmployeeManagementApi.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	//Fetching list of Employees having Same first name
	List<Employee> findByFirstNameContainingIgnoreCase(String fname);

}
