package com.monocept.service;

import java.util.List;
import java.util.Map;

import com.monocept.DTO.PageResponseDTO;
import com.monocept.DTO.StudentRequestDTO;
import com.monocept.DTO.StudentResponseDTO;
import com.monocept.exception.StudentNotFoundException;

public interface StudentService {
	
	  public StudentResponseDTO createStudent(StudentRequestDTO student);
	  public List<StudentResponseDTO> createMultipleStudents(List<StudentRequestDTO> studentRequestDTOs);
	  public StudentResponseDTO getStudentById(int id) throws StudentNotFoundException;
	  public List<StudentResponseDTO> getAllStudents(); 
	  public String deleteStudent(int id) throws StudentNotFoundException; 
	  public StudentResponseDTO updateWithException (int id, StudentRequestDTO stdRequestDTO) throws StudentNotFoundException;
	  public StudentResponseDTO updatePartially (int id,  Map<String, Object> updatedData) throws StudentNotFoundException;
	  public PageResponseDTO<StudentResponseDTO> fetchWithPagination(int pageNum,int pageSize);
}
