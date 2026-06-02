package com.monocept.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.Model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	boolean existsByDepartmentName(String string);
	boolean existsByDepartmentNameAndIdNot(String string, long id);

}
