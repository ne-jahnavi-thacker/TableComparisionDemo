package com.comparison.demo.service;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.comparison.demo.controller.StudentController;
import com.comparison.demo.model.Employee;
import com.comparison.demo.model.Student;
import com.comparison.demo.repository.StudentRepository;
/*
 * @author jahnavi.thacker
 */
@Service
public class StudentService implements IStudentService {

	@Autowired
	private StudentRepository studentRepository;

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	/*
	 * This method will add Student to table
	 * @param Student
	 * @return savedStudent object
	 */
	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}
	/*
	 * This method will retrive all student data
	 * @return list of Student objects
	 */
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	/*
	 * This method will compare data from two tables
	 * and send message accordingly
	 * 
	 * @param lstStudent and lstEmployee
	 * @return ResponseEntity with message
	 */
	@Override
	public ResponseEntity<String> compareData(List<Student> lstStudent, List<Employee> lstEmployee) {
		if (lstStudent.size() != lstEmployee.size())
			return new ResponseEntity<String>("Two tables are NOT identical", HttpStatus.OK);
		Collections.sort(lstStudent);
		Collections.sort(lstEmployee);
		boolean isIdentical = true;
		StringBuilder msg = new StringBuilder();

		for (int i = 0; i < lstStudent.size(); i++) {
			if (!lstStudent.get(i).equals(lstEmployee.get(i))) {
				logger.info("\nTwo tables are not same because of these data \n" + lstStudent.get(i) + "\n"
						+ lstEmployee.get(i) + "\n");

				msg = (msg != null)
						? msg.append("\n\nTwo tables are not same because of these data \n")
								.append(lstStudent.get(i) + "\n" + lstEmployee.get(i))
						: new StringBuilder("Two tables are not same because of these data \n" + lstStudent.get(i)
								+ "\n" + lstEmployee.get(i));

				isIdentical = false;
			}
		}
		if (isIdentical) {
			return new ResponseEntity<String>("Two tables are identical", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(msg != null ? msg.toString() : "Two tables are NOT identical",
					HttpStatus.OK);
		}
	}

}
