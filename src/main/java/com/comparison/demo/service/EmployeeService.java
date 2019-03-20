package com.comparison.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comparison.demo.model.Employee;
import com.comparison.demo.repository.EmployeeRepository;
/*
 * @author jahnavi.thacker
 */
@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	/*
	 * This method will add Employee to table
	 * @param Employee
	 * @return savedEmployee object
	 */
	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	/*
	 * This method will retrive all Employees data
	 * @return list of Employees objects
	 */
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
}
