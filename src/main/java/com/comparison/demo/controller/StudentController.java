package com.comparison.demo.controller;

import java.util.Collections;
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

@RestController
public class StudentController {
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private IEmployeeService employeeService;
	

	
	@GetMapping("/compareData")
	public ResponseEntity<String> getData() {
		List<Student> lstStudent =  studentService.getAllStudents();
		List<Employee> lstEmployee = employeeService.getAllEmployees();
		if(lstStudent.size() != lstEmployee.size())
			return new ResponseEntity<String>("Two tables are NOT identical",  HttpStatus.OK);
		Collections.sort(lstStudent);
		Collections.sort(lstEmployee);
		boolean isIdentical = true;
		
		for(int i=0 ; i < lstStudent.size(); i++) {
			if(!lstStudent.get(i).equals(lstEmployee.get(i))){
				System.out.println("Two tables are not same because of these data \nin Student Table\n" +lstStudent.get(i)+"\nin Employee Table\n"+lstEmployee.get(i));
				isIdentical = false;
				break;
			}
		}
		if(isIdentical) {
			return new ResponseEntity<String>("Two tables are identical",  HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Two tables are NOT identical",  HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		Student savedStudent = studentService.addStudent(student);
		return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> lstStudent =  studentService.getAllStudents();
		
		return new ResponseEntity<List<Student>>(lstStudent, HttpStatus.OK);
		
	}

}
