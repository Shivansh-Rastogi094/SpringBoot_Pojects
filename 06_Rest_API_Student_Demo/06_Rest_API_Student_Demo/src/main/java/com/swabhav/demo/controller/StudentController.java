package com.swabhav.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swabhav.demo.entity.Student;
import com.swabhav.demo.repository.StudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private StudentRepository studentRepository;

	@Autowired
	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@PostMapping("/createMultiple")
	public List<Student> createMultipleStudents(@RequestBody List<Student> student)
	{
		return studentRepository.saveAll(student);
	}

	@GetMapping("/{id}")
	public Optional<Student> getStudentById(@PathVariable int id)
	{
		Optional<Student> foundStudent = studentRepository.findById(id);
		return foundStudent;
	}
	
	
	
	
	
	
	
	
	
	
}
