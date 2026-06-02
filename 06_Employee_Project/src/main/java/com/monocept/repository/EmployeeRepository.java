package com.monocept.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
