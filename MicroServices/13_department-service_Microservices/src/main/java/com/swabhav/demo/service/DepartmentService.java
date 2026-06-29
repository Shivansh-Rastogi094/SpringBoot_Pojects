package com.swabhav.demo.service;

import org.springframework.stereotype.Service;

import com.swabhav.demo.dto.DepartmentRequest;
import com.swabhav.demo.entity.Department;
import com.swabhav.demo.exception.DepartmentNotFoundException;
import com.swabhav.demo.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department createDepartment(
            DepartmentRequest request) {

        Department department = new Department();

        department.setName(request.getName());

        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long departmentId) {

        return departmentRepository.findById(departmentId)
                .orElseThrow(
                        () -> new DepartmentNotFoundException(
                                departmentId
                        )
                );
    }
}
