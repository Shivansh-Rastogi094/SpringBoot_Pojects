package com.monocept.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.dto.EmployeeResponseDTO;
import com.monocept.exception.EmpNotFound;
import com.monocept.model.Employee;
import com.monocept.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	private EmployeeRepository empRepo;
	private ModelMapper modelMap;
	
	@Autowired
	public EmployeeServiceImplementation(EmployeeRepository empRepo,ModelMapper modelMap) {
		this.empRepo=empRepo;
		this.modelMap=modelMap;
	}

	@Override
	public EmployeeResponseDTO fetchById(int id) throws EmpNotFound{
		Employee found = empRepo.findById(id).orElseThrow(()-> new EmpNotFound(id));
		return modelMap.map(found, EmployeeResponseDTO.class);
	}

	@Override
	public List<EmployeeResponseDTO> fetchAllEmp() {
		List<EmployeeResponseDTO> founds =  empRepo.findAll().stream().map(found->modelMap.map(found,EmployeeResponseDTO.class)).toList();
		return founds;
	}

	@Override
	public EmployeeResponseDTO createEmp(Employee emp) {
		return modelMap.map(empRepo.save(emp),EmployeeResponseDTO.class);
	}

	@Override
	public EmployeeResponseDTO updateVia(int id, Employee emp) throws EmpNotFound {
		Employee found =empRepo.findById(id).orElseThrow(()-> new EmpNotFound(id));
		
		found.setEmpAge(emp.getEmpAge());
		found.setEmpCity(emp.getEmpCity());
		found.setEmpCityCode(emp.getEmpCityCode());
		found.setEmpMail(emp.getEmpMail());
		found.setEmpName(emp.getEmpName());
		found.setEmpSalary(emp.getEmpSalary());
		Employee update = empRepo.save(found);
		return modelMap.map(update, EmployeeResponseDTO.class);
	}

	@Override
	public String deleteById(int id) throws EmpNotFound {
		Employee found =empRepo.findById(id).orElseThrow(()-> new EmpNotFound(id));
		empRepo.delete(found);
		return "Employee Record Deleted !";
	}
	

}
