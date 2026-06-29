package com.swabhav.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swabhav.demo.entity.Department;

public interface DepartmentRepository
        extends JpaRepository<Department, Long> {
}
