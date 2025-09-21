package com.subham.spring.exception;

public class StudentNotFoundException extends RuntimeException {


	public  StudentNotFoundException(String message) {
		super(message);
	}

}
