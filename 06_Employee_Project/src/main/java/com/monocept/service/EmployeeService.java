package com.monocept.service;

import java.util.List;

import com.monocept.dto.EmployeeResponseDTO;
import com.monocept.exception.EmpNotFound;
import com.monocept.model.Employee;

public interface EmployeeService {
 
	public EmployeeResponseDTO fetchById(int id) throws EmpNotFound;
	public List<EmployeeResponseDTO> fetchAllEmp(); 
	public EmployeeResponseDTO createEmp(Employee emp);
	public EmployeeResponseDTO updateVia(int id,Employee emp) throws EmpNotFound;
	public String deleteById (int id) throws EmpNotFound;
}
