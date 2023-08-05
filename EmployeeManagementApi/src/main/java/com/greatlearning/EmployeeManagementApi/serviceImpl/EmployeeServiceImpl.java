package com.greatlearning.EmployeeManagementApi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.EmployeeManagementApi.entity.Employee;
import com.greatlearning.EmployeeManagementApi.repository.EmployeeRepository;
import com.greatlearning.EmployeeManagementApi.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public Employee addEmployee(Employee emp) {

		return empRepository.saveAndFlush(emp);
	}

	@Override
	public Employee updateEmployee(long eid, Employee emp) {

		return null;
	}

	@Override
	public Employee getEmployee(long eid) {

		return empRepository.findById(eid).get();
	}

	@Override
	public List<Employee> getAllEmployees() {

		return empRepository.findAll();
	}

	@Override
	public String deleteEmployee(long eid) {
		empRepository.deleteById(eid);
		return "Employee Details Deleted";

	}

	@Override
	public List<Employee> getEmployeeByName(String fname) {

		return empRepository.findByFirstNameContainingIgnoreCase(fname);
	}

	@Override
	public List<Employee> sortEmployeeByFirstName(String order) {

		Direction direction = order.equalsIgnoreCase("desc") ? Direction.DESC : Direction.ASC;
		return empRepository.findAll(Sort.by(direction, "firstName"));

	}

}
