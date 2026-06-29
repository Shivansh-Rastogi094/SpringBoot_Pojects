package com.swabhav.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swabhav.demo.dto.DepartmentRequest;
import com.swabhav.demo.dto.DepartmentWithEmployeesResponse;
import com.swabhav.demo.dto.EmployeeResponse;
import com.swabhav.demo.entity.Department;
import com.swabhav.demo.service.DepartmentRestService;
import com.swabhav.demo.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
	@RequestMapping("/departments")
	@RequiredArgsConstructor
	public class DepartmentController {

	    private final DepartmentService departmentService;
	    private final DepartmentRestService departmentRestService;
	    
	    @PostMapping
	    public ResponseEntity<Department> createDepartment(
	            @RequestBody DepartmentRequest request) {

	        Department createdDepartment =
	                departmentService.createDepartment(request);

	        return ResponseEntity
	                .status(HttpStatus.CREATED)
	                .body(createdDepartment);
	    }

	 
	    @GetMapping("/{departmentId}")
	    public ResponseEntity<Department> getDepartmentById(
	            @PathVariable Long departmentId) {

	        Department department =
	                departmentService.getDepartmentById(departmentId);

	        return ResponseEntity.ok(department);
	    }
	    
	    @GetMapping("/{departmentId}/rest-template")
	    public ResponseEntity<DepartmentWithEmployeesResponse> getEmployeesWithRest(
	            @PathVariable long departmentId) {

	        DepartmentWithEmployeesResponse response =
	                departmentRestService.getDepartmentWithEmployee(departmentId);

	        return ResponseEntity.ok(response);
	    }
	
}
