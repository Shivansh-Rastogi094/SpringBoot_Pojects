package com.monocept.exception;

public class StudentNotFoundException extends Exception{
	public StudentNotFoundException(int id) {
		super("Student not found with id:"+id);
	}
}
