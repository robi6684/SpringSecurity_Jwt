package com.monocept.studentcrudrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.studentcrudrest.entities.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

}
