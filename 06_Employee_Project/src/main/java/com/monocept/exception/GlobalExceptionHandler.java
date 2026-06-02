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
	@ExceptionHandler(EmpNotFound.class)
	public ResponseEntity<Map<String,Object>> handleEmpNotFound(EmpNotFound ex){
		
		Map<String,Object> errbody = new HashMap<>();
		
		errbody.put("Timestamp", LocalDateTime.now());
		errbody.put("Status",HttpStatus.NOT_FOUND);
		errbody.put("Message",ex.getMessage());
		
		return new ResponseEntity<>(errbody,HttpStatus.NOT_FOUND);
	}
}
