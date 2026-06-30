package com.swabhav.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.swabhav.demo.client.EmployeeClient;
import com.swabhav.demo.client.EmployeeFeignClient;
import com.swabhav.demo.dto.DepartmentWithEmployeesResponse;
import com.swabhav.demo.dto.EmployeeResponse;
import com.swabhav.demo.entity.Department;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentRestService {

	private final DepartmentService departmentService;
	private final EmployeeFeignClient feignClient;
	
	public DepartmentWithEmployeesResponse getDepartmentWithEmployee (long departmentId) {
		Department department = departmentService.getDepartmentById(departmentId);
		
		List<EmployeeResponse> 	employee = feignClient.getEmployeeByDepartmentId(departmentId); 
		
		return new DepartmentWithEmployeesResponse(department.getId(),department.getName(),employee);
	}
	
}
