package com.monocept.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.monocept.DTO.PageResponseDTO;
import com.monocept.DTO.StudentRequestDTO;
import com.monocept.DTO.StudentResponseDTO;
import com.monocept.Exception.DuplicateResourceException;
import com.monocept.Exception.StudentNotFound;
import com.monocept.Repository.StudentProfileRepository;
import com.monocept.Repository.StudentRepository;
import com.monocept.model.Student;
import com.monocept.model.StudentProfile;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {

	private final ModelMapper modelMap;
	private final StudentRepository studentRepository;
	private final StudentProfileRepository profileRepository;

	@Override
	public StudentResponseDTO createStudent(StudentRequestDTO requestDTO) throws DuplicateResourceException {
		if (!profileRepository.existsByEmail(requestDTO.getStudentProfile().getEmail())) {

			Student tempStud = modelMap.map(requestDTO, Student.class);
			tempStud.getStudentProfile().setStudent(tempStud);
			studentRepository.save(tempStud);

			return modelMap.map(tempStud, StudentResponseDTO.class);
		} else {
			throw new DuplicateResourceException(requestDTO.getStudentProfile().getEmail());
		}
	}

	@Override
	public List<StudentResponseDTO> getAllStudents() {
		List<StudentResponseDTO> Students = studentRepository.findAll().stream()
				.map(student -> modelMap.map(student, StudentResponseDTO.class)).toList();
		return Students;
	}

	void validatePagination(int pageNumber, int pageSize) {
		if (pageNumber < 0) {
	        throw new IllegalArgumentException(
	                "Page number cannot be negative");
	    }

	    if (pageSize <= 0) {
	        throw new IllegalArgumentException(
	                "Page size must be greater than 0");
	    }
	}
	
	@Override
	public PageResponseDTO<StudentResponseDTO> getAllStudentsWithPagination(
	        int pageNumber,
	        int pageSize) {

	    validatePagination(pageNumber, pageSize);

	    Pageable pageable = PageRequest.of(pageNumber, pageSize);

	    Page<Student> studentPage = studentRepository.findAll(pageable);

	    List<StudentResponseDTO> content = studentPage.getContent()
	            .stream()
	            .map(con-> modelMap.map(studentPage, StudentResponseDTO.class))
	            .toList();

	    return new PageResponseDTO<>(
	            content,
	            studentPage.getNumber(),
	            studentPage.getSize(),
	            studentPage.getTotalPages(),
	            studentPage.isLast(),
	            studentPage.getTotalElements()
	    );
	}

	@Override
	public StudentResponseDTO getStudentById(Long id) throws StudentNotFound {
		if (studentRepository.existsById(id)) {
			StudentResponseDTO tempStud = modelMap.map(studentRepository.findById(id), StudentResponseDTO.class);
			return tempStud;
		} else {
			throw new StudentNotFound(id);
		}
	}

	@Override
	public StudentResponseDTO updateStudent(Long id, StudentRequestDTO requestDto)
			throws StudentNotFound, DuplicateResourceException {

		Student existingStud = studentRepository.findById(id).orElseThrow(() -> new StudentNotFound(id));
		if (profileRepository.existsByEmailAndIdNot(requestDto.getStudentProfile().getEmail(), id)) {
			existingStud.setAge(requestDto.getAge());
			existingStud.setFullName(requestDto.getFullName());
			
			StudentProfile profile = existingStud.getStudentProfile();
			profile.setEmail(requestDto.getStudentProfile().getEmail());
			profile.setPhone(requestDto.getStudentProfile().getPhone());
			profile.setCity(requestDto.getStudentProfile().getCity());
			
			profile.setStudent(existingStud);
			existingStud.setStudentProfile(profile);
			
			Student updatedStudent = studentRepository.save(existingStud);
			
			return modelMap.map(updatedStudent, StudentResponseDTO.class);
		} else {
			throw new DuplicateResourceException(requestDto.getStudentProfile().getEmail());
		}
	}

	@Override
	public String deleteStudent(Long id) throws StudentNotFound {
		Student existingStud = studentRepository.findById(id).orElseThrow(() -> new StudentNotFound(id));
		studentRepository.delete(existingStud);
		return "Record Deleted Successfully";
	}

}
