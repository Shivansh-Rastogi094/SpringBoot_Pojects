package com.monocept.Exception;

public class DuplicateResourceException extends Exception{
	public DuplicateResourceException(String email){
		super("Student Already Exists with email:"+email);
	}
}
