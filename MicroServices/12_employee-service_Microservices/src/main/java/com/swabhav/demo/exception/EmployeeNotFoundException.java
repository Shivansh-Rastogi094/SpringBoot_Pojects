package com.swabhav.demo.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long employeeId) {
        super("Employee not found with ID: " + employeeId);
    }
}
