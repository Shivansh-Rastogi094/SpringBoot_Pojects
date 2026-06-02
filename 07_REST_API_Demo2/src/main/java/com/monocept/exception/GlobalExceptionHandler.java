	package com.monocept.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleStudentNotFoundException(StudentNotFoundException ex){
		
		Map<String,Object> errorBody = new HashMap<>();
		
		errorBody.put("TimeStamp", LocalDateTime.now());
		errorBody.put("Status", HttpStatus.NOT_FOUND.value());
		errorBody.put("Error", "Not Found");
		errorBody.put("Message", ex.getMessage());
		
		return new ResponseEntity<>(errorBody,HttpStatus.NOT_FOUND);
	}
}
