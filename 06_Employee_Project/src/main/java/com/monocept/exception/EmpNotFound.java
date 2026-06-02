package com.monocept.exception;

public class EmpNotFound extends Exception{
	public EmpNotFound(int id) {
		super("Employee not found with id:"+id);
	}

}
