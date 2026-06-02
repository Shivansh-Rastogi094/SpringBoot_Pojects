package com.monocept.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<Map<String,Object>> handleDuplicateResourceException(DuplicateResourceException ex){
		Map<String,Object> err = new HashMap<>();
		
		err.put("TimeStamp", LocalDateTime.now());
		err.put("Status", HttpStatus.NOT_FOUND.value());
		err.put("Error", "Not Found");
		err.put("Message", ex.getMessage());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StudentNotFound.class)
	public ResponseEntity<Map<String,Object>> handleStudentNotFound(StudentNotFound ex){
		Map<String,Object> err = new HashMap<>();
		
		err.put("TimeStamp", LocalDateTime.now());
		err.put("Status", HttpStatus.NOT_FOUND.value());
		err.put("Error", "Not Found");
		err.put("Message", ex.getMessage());
		
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
}
