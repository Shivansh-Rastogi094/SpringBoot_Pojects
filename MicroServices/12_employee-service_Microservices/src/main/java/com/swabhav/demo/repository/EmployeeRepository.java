package com.swabhav.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swabhav.demo.entity.Employee;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentId(Long departmentId);
}
