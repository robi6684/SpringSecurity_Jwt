package com.monocept.studentcrudrest.service;

import java.util.List;

import org.springframework.data.domain.Page;


import com.monocept.studentcrudrest.entities.Student;

public interface StudentService {
	List<Student> getAllStudents();
	Student getStudentByRollNumber(int roll_number);
	void saveStudent(Student student);
	void saveAllStudent(List<Student> students);
	void deleteStudent(Student student);
	void update(Student student);
	Page<Student>getStudentPageWise(int pageno, int pagesize);
	Page<Student>getStudentPageWiseSorted(int pageno, int pagesize, String sortObject);
}
