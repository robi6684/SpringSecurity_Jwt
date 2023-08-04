package com.monocept.studentcrudrest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.studentcrudrest.entities.Student;
import com.monocept.studentcrudrest.exception.StudentGetAllStudentException;
import com.monocept.studentcrudrest.exception.StudentGetStudentException;
import com.monocept.studentcrudrest.service.StudentService;

@RestController
@RequestMapping("/studentapp")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students = studentService.getAllStudents();
		if(students.size()==0)
			throw new StudentGetAllStudentException("Student List is Empty");
		
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	@GetMapping("/getStudent/{roll_Number}")
	public ResponseEntity<Student>getStudentByRollNumber(@PathVariable(name="roll_Number") int roll_Number) {
		Student student = studentService.getStudentByRollNumber(roll_Number);
		if(student == null)
			throw new StudentGetStudentException("This roll number does not exist");
		
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@PostMapping("/saveStudent")
	public void saveStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
	}
	
	@PostMapping("/saveAllStudent")
	public void saveAllStudents(@RequestBody List<Student> students) {
		studentService.saveAllStudent(students);
	}
	
	@DeleteMapping("/deleteStudent")
	public void delete(@RequestBody Student student) {
		studentService.deleteStudent(student);
	}
	
	@PutMapping("/updateStudent/{roll_Number}")
	public void update(@PathVariable(name="roll_Number") int roll_Number) {
		Student student = studentService.getStudentByRollNumber(roll_Number);
		student.setEmail("changedEmail@gmail.com");
		studentService.update(student);
	}
	
	@GetMapping("/getStudentPageWise/{pageno}/{pagesize}")
	public Page<Student> getStudentPageWise(@PathVariable(name="pageno") int pageno, @PathVariable(name="pagesize")int pagesize){
		return studentService.getStudentPageWise(pageno, pagesize);
	}
	
	@GetMapping("/getStudentPageWiseSorted/{pageno}/{pagesize}/{sortObject}")
	public ResponseEntity<Page<Student>> getStudentPageWiseSorted(@PathVariable(name="pageno") int pageno, 
			@PathVariable(name="pagesize")int pagesize, @PathVariable(name="sortObject") String sortObject){
		return new ResponseEntity<>(studentService.getStudentPageWiseSorted(pageno, pagesize, sortObject),HttpStatus.OK);
	}
	
	@ExceptionHandler(value=StudentGetAllStudentException.class)
	public ResponseEntity<StudentError> getAllStudentException(StudentGetAllStudentException exception){
		StudentError error = new StudentError(HttpStatus.NOT_FOUND.value(),exception.getMessage(),System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value=StudentGetStudentException.class)
	public ResponseEntity<StudentError> getStudentException(StudentGetStudentException exception){
		StudentError error = new StudentError(HttpStatus.NOT_FOUND.value(),exception.getMessage(),System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	

}
