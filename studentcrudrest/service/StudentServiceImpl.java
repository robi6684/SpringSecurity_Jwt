package com.monocept.studentcrudrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.monocept.studentcrudrest.entities.Student;
import com.monocept.studentcrudrest.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentByRollNumber(int roll_number) {
		Student student = null;
		Optional<Student> findStudent = studentRepository.findById(roll_number);
		
		if(findStudent.isPresent())
			student = findStudent.get();
		
		return student;
		
	}

	@Override
	@Transactional
	public void saveStudent(Student student) {
		studentRepository.save(student);
		
	}

	@Override
	@Transactional
	public void saveAllStudent(List<Student> students) {
		studentRepository.saveAll(students);
		
	}

	@Override
	@Transactional
	public void deleteStudent(Student student) {
		studentRepository.delete(student);
	}
	
	@Override
	@Transactional
	public void update(Student student) {
		studentRepository.save(student);
	}

	@Override
	public Page<Student> getStudentPageWise(int pageno, int pagesize) {
		Pageable pageable = PageRequest.of(pageno, pagesize);
		return studentRepository.findAll(pageable);
		
	}

	@Override
	public Page<Student> getStudentPageWiseSorted(int pageno, int pagesize, String sortObject) {
		Pageable pageable = PageRequest.of(pageno, pagesize, Sort.by(sortObject).descending());
		return studentRepository.findAll(pageable);
	}

}
