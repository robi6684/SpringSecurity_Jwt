package com.monocept.studentcrudrest.exception;

public class StudentGetAllStudentException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	

	public StudentGetAllStudentException() {
		super();
		// TODO Auto-generated constructor stub
	}



	public StudentGetAllStudentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}



	public StudentGetAllStudentException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}



	public StudentGetAllStudentException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}



	public StudentGetAllStudentException(String message) {
		super();
		this.message = message;
	}



	public String getMessage() {
		return message;
	}
	

}
