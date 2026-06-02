package com.monocept.Exception;

public class ResourceNotFoundException extends Exception {
	public ResourceNotFoundException(long id) {
		super("Requested department not found with id:"+id);
	}
}
