package com.monocept.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
