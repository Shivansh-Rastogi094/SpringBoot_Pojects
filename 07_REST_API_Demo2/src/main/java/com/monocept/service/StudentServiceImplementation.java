package com.monocept.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.monocept.DTO.PageResponseDTO;
import com.monocept.DTO.StudentRequestDTO;
import com.monocept.DTO.StudentResponseDTO;
import com.monocept.exception.StudentNotFoundException;
import com.monocept.model.Student;
import com.monocept.repo.StudentRepo;

@Service
public class StudentServiceImplementation implements StudentService {

	private StudentRepo stdRepo;
	private ModelMapper modelMap;

	public StudentServiceImplementation(StudentRepo stdRepo,ModelMapper modelMap) {
		this.stdRepo = stdRepo;
		this.modelMap=modelMap;
	}
	
	public Student toEntity(StudentRequestDTO studentRequestDTO) {
		Student std =new Student();
		std.setFullName(studentRequestDTO.getFullName());
		std.setAge(studentRequestDTO.getAge());
		return std;
	}
	
	public StudentResponseDTO toResponseDTO(Student student) {
		StudentResponseDTO stdDTO = new StudentResponseDTO();
		stdDTO.setFullName(student.getFullName());
		return stdDTO;
	}

	@Override
	public StudentResponseDTO createStudent(StudentRequestDTO student) {
		Student tempStd = stdRepo.save(modelMap.map(student, Student.class));
		return (modelMap.map(tempStd, StudentResponseDTO.class));
	}

	@Override
	public List<StudentResponseDTO> createMultipleStudents(List<StudentRequestDTO> student) {
		List <Student> Studs = student.stream().map(stud->modelMap.map(student, Student.class)).toList();
		stdRepo.saveAll(Studs);
		return Studs.stream().map(stud->modelMap.map(stud, StudentResponseDTO.class)).toList();
	}

	@Override
	public StudentResponseDTO getStudentById(int id) throws StudentNotFoundException {
		Student student = stdRepo.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		return modelMap.map(student,StudentResponseDTO.class);
	}

	@Override
	public List<StudentResponseDTO> getAllStudents() {

		return stdRepo.findAll().stream().map(student-> modelMap.map(student, StudentResponseDTO.class)).toList();
	}

	@Override
	public String deleteStudent(int id) throws StudentNotFoundException {
		Student existingStudent = stdRepo.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		stdRepo.delete(existingStudent);
		return ("Student Record deleted");
	}

	@Override
	public StudentResponseDTO updateWithException(int id, StudentRequestDTO std) throws StudentNotFoundException {
		Student existingStudent = stdRepo.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		existingStudent.setAge(std.getAge());
		existingStudent.setFullName(std.getFullName());
		return modelMap.map((stdRepo.save(existingStudent)),StudentResponseDTO.class);
	}

	@Override
	public StudentResponseDTO updatePartially(int id, Map<String, Object> updatedData) throws StudentNotFoundException {
		Student existingStudent = stdRepo.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
		if (updatedData.containsKey("full_name"))
			existingStudent.setFullName((String) updatedData.get("full_name"));
		if (updatedData.containsKey("age"))
			existingStudent.setAge(Integer.parseInt(updatedData.get("age").toString()));
		return modelMap.map((stdRepo.save(existingStudent)),StudentResponseDTO.class);
	}

	@Override
	public PageResponseDTO<StudentResponseDTO> fetchWithPagination(int pageNum, int pageSize) {
		PageRequest pageable = PageRequest.of(pageNum, pageSize);
		Page<Student> studentPage= stdRepo.findAll(pageable);
		List<Student> students = studentPage.getContent();
		List<StudentResponseDTO> studentResponses = new ArrayList();
		
		for(Student s : students) {
			StudentResponseDTO responseDTO =modelMap.map(s, StudentResponseDTO.class);
			studentResponses.add(responseDTO);
		}
		
		PageResponseDTO<StudentResponseDTO> pageResponseDTO =new PageResponseDTO<>();
		
		pageResponseDTO.setContent(studentResponses);
		pageResponseDTO.setPageNum(studentPage.getNumber());
		pageResponseDTO.setPageSize(studentPage.getSize());
		pageResponseDTO.setTotalCount(studentPage.getTotalElements());
		pageResponseDTO.setLastPage(studentPage.isLast());
		pageResponseDTO.setTotalPages(studentPage.getTotalPages());
		
		return pageResponseDTO;
	}

}
