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
import com.comparison.demo.model.Student;
import com.comparison.demo.service.IEmployeeService;
import com.comparison.demo.service.IStudentService;

/*
 * @author jahnavi.thacker
 */

@RestController
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@Autowired
	private IEmployeeService employeeService;

	
	/*
	 * This method will compare data from two tables
	 * and send message accordingly
	 * 
	 * @return ResponseEntity with message
	 */
	@GetMapping("/compareData")
	public ResponseEntity<String> getData() {
		List<Student> lstStudent = studentService.getAllStudents();
		List<Employee> lstEmployee = employeeService.getAllEmployees();

		return studentService.compareData(lstStudent, lstEmployee);

	}

	/*
	 * This method will add Student to table
	 * @param RequestBody Student
	 * @return ResponseEntity of savedStudent object
	 */
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student savedStudent = studentService.addStudent(student);
		return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
	}

	/*
	 * This method will retrive all student data
	 * @return ResponseEntity of list of Student objects
	 */
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> lstStudent = studentService.getAllStudents();

		return new ResponseEntity<List<Student>>(lstStudent, HttpStatus.OK);

	}

}
