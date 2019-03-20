package com.comparison.demo.service;


import java.util.List;

import com.comparison.demo.model.Student;

public interface IStudentService {

	Student addStudent(Student student);

	List<Student> getAllStudents();

}
