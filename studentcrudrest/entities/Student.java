package com.monocept.studentcrudrest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="roll_number")
	private int rollNumber;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	
	public Student() {

	}

	public Student(String first_name, String last_name, String email) {
		this.firstName = first_name;
		this.lastName = last_name;
		this.email = email;
	}

	public int getRoll_number() {
		return rollNumber;
	}

	public void setRoll_number(int roll_number) {
		this.rollNumber = roll_number;
	}

	public String getFirst_name() {
		return firstName;
	}

	public void setFirst_name(String first_name) {
		this.firstName = first_name;
	}

	public String getLast_name() {
		return lastName;
	}

	public void setLast_name(String last_name) {
		this.lastName = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [roll_number=" + rollNumber + ", first_name=" + firstName + ", last_name=" + lastName
				+ ", email=" + email + "]";
	}
	
	

}
