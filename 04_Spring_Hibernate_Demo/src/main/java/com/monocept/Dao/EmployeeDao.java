package com.monocept.Dao;

import java.util.List;

import com.monocept.model.Employee;

public interface EmployeeDao {
	
	public void insertEmployee(Employee employee);
	public Employee findEmployeeById(int empId);
	public List<Employee> findAllEmployee();
	public List<Employee> findEmployeeBYAge(int empAge);
	public List<Employee> findEmployeeBYCity(int empCityCode);
	public List<Employee> findEmployeeBYName(String empName);
	public List<Employee> findEmployeeBYSalary(int empSalary);
	public Employee updateSalaryBYId(Integer empId);
	public void deleteEmployeeBYId(Integer empId);

}
