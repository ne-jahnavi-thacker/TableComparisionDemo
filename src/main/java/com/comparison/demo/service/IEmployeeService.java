package com.comparison.demo.service;


import java.util.List;

import com.comparison.demo.model.Employee;

public interface IEmployeeService {

	Employee addEmployee(Employee employee);

	List<Employee> getAllEmployees();

}
