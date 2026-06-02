package com.monocept.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.DTO.PageResponseDTO;
import com.monocept.DTO.StudentRequestDTO;
import com.monocept.DTO.StudentResponseDTO;
import com.monocept.Exception.DuplicateResourceException;
import com.monocept.Exception.StudentNotFound;
import com.monocept.Service.StudentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@SecurityRequirement(name = "basicAuth")
public class StudentController {
	
	private final StudentService studentService;
	
	@PostMapping("/create")
	public StudentResponseDTO createStudent(@RequestBody StudentRequestDTO requestDTO) throws DuplicateResourceException {
		return studentService.createStudent(requestDTO);
	}
	
	@GetMapping("/getAll")
	public List<StudentResponseDTO> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/page")
	public PageResponseDTO<StudentResponseDTO> getAllStudentsWithPagination(@RequestParam(defaultValue = "0") int pageNumber, @RequestParam(defaultValue = "5") int pageSize){
		return studentService.getAllStudentsWithPagination(pageNumber, pageSize);
	}
	
	@GetMapping("{id}")
	public StudentResponseDTO getStudentById(@PathVariable long id) throws StudentNotFound {
		return studentService.getStudentById(id);
	}
	
	@PutMapping("{id}")
	public StudentResponseDTO updateStudent (@PathVariable long id, @RequestBody StudentRequestDTO requestDTO) throws StudentNotFound, DuplicateResourceException {
		return studentService.updateStudent(id, requestDTO);
	}
	
	@DeleteMapping("{id}")
	public String deleteStudent(@PathVariable long id) throws StudentNotFound{
		return studentService.deleteStudent(id);
	}	
	
	
}
