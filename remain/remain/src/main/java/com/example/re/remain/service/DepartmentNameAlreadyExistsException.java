package com.example.re.remain.service;

public class DepartmentNameAlreadyExistsException extends RuntimeException {

	public DepartmentNameAlreadyExistsException(String warning) {
        super(warning);
    }
	
}
