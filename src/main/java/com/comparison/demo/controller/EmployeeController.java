package com.comparison.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.comparison.demo.model.Employee;
import com.comparison.demo.service.IEmployeeService;
/*
 * @author jahnavi.thacker
 */
@RestController
public class EmployeeController {

	@Autowired
	private IEmployeeService employeeService;

	/*
	 * This method will add Employee to table
	 * 
	 * @param RequestBody Employee
	 * @return ResponseEntity of savedEmployee object
	 */
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
	}

	/*
	 * This method will retrive all employee data
	 * @return ResponseEntity of list of Employee objects
	 */
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> lstEmployee = employeeService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(lstEmployee, HttpStatus.OK);

	}
}
