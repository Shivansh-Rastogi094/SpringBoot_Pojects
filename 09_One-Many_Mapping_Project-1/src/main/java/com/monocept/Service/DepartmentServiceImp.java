package com.monocept.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.DTO.DepartmentRequestDto;
import com.monocept.DTO.DepartmentResponseDto;
import com.monocept.DTO.EmployeeRequestDto;
import com.monocept.DTO.PageResponseDto;
import com.monocept.Exception.DuplicateResourceException;
import com.monocept.Exception.ResourceNotFoundException;
import com.monocept.Model.Department;
import com.monocept.Model.Employee;
import com.monocept.Repo.DepartmentRepository;
import com.monocept.Repo.EmployeeRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentServiceImp implements DepartmentService {

	private DepartmentRepository deptRepo;
	private EmployeeRepository empRepo;
	private ModelMapper modelMap;

	@Autowired
	public DepartmentServiceImp(DepartmentRepository deptRepo, EmployeeRepository empRepo, ModelMapper modelMap) {
		this.deptRepo = deptRepo;
		this.empRepo = empRepo;
		this.modelMap = modelMap;
	}

	@Override
	@Transactional
	public DepartmentResponseDto createDepartment(DepartmentRequestDto requestDto) throws DuplicateResourceException {
		
		log.info("Creating department: {}",
		        requestDto.getDepartmentName());
		// check dept name exists or not
		if (deptRepo.existsByDepartmentName(requestDto.getDepartmentName())) {
			log.warn("Duplicate department name found: {}",
			        requestDto.getDepartmentName());
			throw new DuplicateResourceException(requestDto.getDepartmentName());
		}

		// check atleast 1 employee is there
		if (requestDto.getEmployees() == null || requestDto.getEmployees().isEmpty()) {
			throw new IllegalArgumentException("At least one employee must be provided");
		}
		
		// check for duplicate employee names
		for(EmployeeRequestDto employeeRequestDto : requestDto.getEmployees()) {
			if(empRepo.existsByEmail(employeeRequestDto.getEmail())) {
				log.warn("Duplicate employee email found: {}",
				        employeeRequestDto.getEmail());
				 throw new DuplicateResourceException("Employee email already exists");
			}
			
		}
		// dto to entity
		Department department =modelMap.map(requestDto, Department.class);
		
		// setting employee data
		for(Employee employee : department.getEmployees()) {
			employee.setDepartment(department);
		}
		
		// saving both data together
		Department savedDepartment = deptRepo.save(department);
		
		log.info("Department created successfully with id: {}",
		        savedDepartment.getId());
		// return response
		return modelMap.map(savedDepartment, DepartmentResponseDto.class);
	}

	@Override
	public List<DepartmentResponseDto> getAllDepartments() {
		log.info("Fetching all departments");
		List<DepartmentResponseDto> departments = deptRepo.findAll().stream().map(department->modelMap.map(department, DepartmentResponseDto.class)).toList();
		log.info("Successfully fetched {} departments",
		        departments.size());
		return departments;
	}

	@Override
	public PageResponseDto<DepartmentResponseDto> getAllStudentsWithPagination(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DepartmentResponseDto getDepartmentById(long id) throws ResourceNotFoundException {
		log.info("Fetching department with id: {}",
		        id);
		if(deptRepo.existsById(id)) {
			DepartmentResponseDto temp = modelMap.map(deptRepo.findById(id),DepartmentResponseDto.class);
			log.info("Department fetched successfully with id: {}",
			        id);
			return temp;
		}else {
			log.warn("Department not found with id: {}",
			        id);
		throw new ResourceNotFoundException(id);	
		}
		
	}

	@Override
	@Transactional
	public DepartmentResponseDto updateDepartment(Long departmentId,DepartmentRequestDto requestDto) throws ResourceNotFoundException, DuplicateResourceException {
		log.info("Updating department with id: {}",
		        departmentId);
		// check if department exsists
		Department department =deptRepo.findById(departmentId).orElseThrow(()-> new ResourceNotFoundException(departmentId));
		
		log.warn("Department not found with id: {}",
		        departmentId);
		// check duplicate dept name for others
		if(deptRepo.existsByDepartmentNameAndIdNot(requestDto.getDepartmentName(), departmentId)) {
			log.warn("Department name already exists: {}",
			        requestDto.getDepartmentName());
			throw new DuplicateResourceException("Duplicate department name, already present in another department");
		}
		// check for duplicate emp email in other depts
		for(EmployeeRequestDto empDto : requestDto.getEmployees()) {
			if(empRepo.existsByEmailAndIdNot(empDto.getEmail(),departmentId)) {
				log.warn("Employee email already exists: {}",
				        empDto.getEmail());
				throw new DuplicateResourceException("Duplicate employee email, already present in another department");
			}
		}
		
		department.setDepartmentName(requestDto.getDepartmentName());
		department.setLocation(requestDto.getLocation());
		
		department.getEmployees().clear();
		
		for(EmployeeRequestDto empDto : requestDto.getEmployees()) {
			
			Employee emp = modelMap.map(empDto, Employee.class);
			emp.setDepartment(department);
			department.getEmployees().add(emp);
		}
		
		Department updated = deptRepo.save(department);
		log.info("Department updated successfully with id: {}",
		        departmentId);
		
		return modelMap.map(updated, DepartmentResponseDto.class);
	}

	@Override
	public String deleteDepartment(long id) throws ResourceNotFoundException {
		Department department =deptRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
		deptRepo.delete(department);
		log.info("Department deleted successfully with id: {}",
		        id);
		return "Department Record Deleted";
	}
}
