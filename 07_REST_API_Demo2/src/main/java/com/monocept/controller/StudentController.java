package com.monocept.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
import com.monocept.exception.StudentNotFoundException;
import com.monocept.model.Student;
import com.monocept.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
 
	private StudentService studentService;
 
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public StudentResponseDTO toResponseDTO(Student student) {
		StudentResponseDTO stdDTO = new StudentResponseDTO();
		stdDTO.setFullName(student.getFullName());
		return stdDTO;
	}
 
	@PostMapping("/create")
	public StudentResponseDTO createStudent(@RequestBody StudentRequestDTO student) {
		return studentService.createStudent(student);
	}
//	
	@PostMapping("/createMultiple")
	public List<StudentResponseDTO> createMultipleStudents(@RequestBody List<StudentRequestDTO> student)
	{
		return studentService.createMultipleStudents(student);
	}

	@GetMapping("/find/{id}")
	public StudentResponseDTO getStudentById(@PathVariable int id) throws StudentNotFoundException
	{
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/getAll")
	public List<StudentResponseDTO> getAllStudents() {
	    return studentService.getAllStudents();
	}
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) throws StudentNotFoundException {
		return studentService.deleteStudent(id);
	}
//	
//	// Update Method via response entity
//	@PutMapping("/update/{id}")
//	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
//		Optional<Student> foundStudent = studentRepository.findById(id);
//		
//		if(foundStudent.isPresent()) {
//			
//			Student existingStudent = foundStudent.get();
//			existingStudent.setAge(student.getAge());
//			existingStudent.setFullName(student.getFullName());
//	
//			Student updatedStudent = studentRepository.save(existingStudent);
//			
//			return ResponseEntity.ok(updatedStudent);
//		}
//		else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//	}
//	
//	// Update via Respone entity+Exception
	@PutMapping("/updateVia/{id}")
	public StudentResponseDTO updateWithException(@PathVariable int id, @RequestBody StudentRequestDTO student) throws StudentNotFoundException {
		    return studentService.updateWithException(id,student);
	}
//	
	@PatchMapping("/updatePartial/{id}")
	public StudentResponseDTO updatePartially (@PathVariable int id, @RequestBody Map<String, Object> updatedData) throws StudentNotFoundException {
		 return studentService.updatePartially(id, updatedData);
	}
	@GetMapping("fetchFrom")
	public PageResponseDTO<StudentResponseDTO> fetchWithPagination(@RequestParam(defaultValue = "0") int pageNum,@RequestParam(defaultValue = "5")  int pageSize){
		return studentService.fetchWithPagination(pageNum, pageSize);
	}

} // end of class
	
