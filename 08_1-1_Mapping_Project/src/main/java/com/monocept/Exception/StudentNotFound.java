package com.monocept.Exception;

public class StudentNotFound extends Exception {
	public StudentNotFound(long id) {
		super("Student does not exsist by id:"+id);
	}
}
