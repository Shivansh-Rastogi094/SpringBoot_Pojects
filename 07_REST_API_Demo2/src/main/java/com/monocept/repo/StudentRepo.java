package com.monocept.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
