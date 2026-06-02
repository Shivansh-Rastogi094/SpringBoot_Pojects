package com.monocept.Service;

import java.util.List;

import com.monocept.DTO.PageResponseDTO;
import com.monocept.DTO.StudentRequestDTO;
import com.monocept.DTO.StudentResponseDTO;
import com.monocept.Exception.DuplicateResourceException;
import com.monocept.Exception.StudentNotFound;

public interface StudentService {

	StudentResponseDTO createStudent(StudentRequestDTO requestDTO) throws DuplicateResourceException ;
	List<StudentResponseDTO> getAllStudents();
	PageResponseDTO<StudentResponseDTO> getAllStudentsWithPagination(int pageNumber, int pageSize);
	StudentResponseDTO getStudentById(Long id) throws StudentNotFound;
	StudentResponseDTO updateStudent(Long id, StudentRequestDTO requestDto) throws StudentNotFound, DuplicateResourceException ;
	String deleteStudent(Long id) throws StudentNotFound;
}
