package com.monocept.studentcrudrest.exception;

public class StudentGetStudentException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String message;
	
	
	
	public StudentGetStudentException() {
		super();
		// TODO Auto-generated constructor stub
	}



	public StudentGetStudentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}



	public StudentGetStudentException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}



	public StudentGetStudentException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}



	public StudentGetStudentException(String message) {
		super();
		this.message = message;
	}



	public String getMessage() {
		return this.message;
	}

}
