package com.comparison.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.comparison.demo.model.Employee;
import com.comparison.demo.model.Student;

public interface IStudentService {

	Student addStudent(Student student);

	List<Student> getAllStudents();

	ResponseEntity<String> compareData(List<Student> lstStudent, List<Employee> lstEmployee);

}
