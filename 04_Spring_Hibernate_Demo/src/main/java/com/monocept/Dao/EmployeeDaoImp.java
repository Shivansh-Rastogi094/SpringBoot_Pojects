package com.monocept.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monocept.model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDaoImp implements EmployeeDao {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void insertEmployee(Employee employee) {
		entityManager.persist(employee);
	}

	@Override
	public Employee findEmployeeById(int empId) {
		return	entityManager.find(Employee.class, empId);
	}

	@Override
	public List<Employee> findAllEmployee() {
		TypedQuery<Employee> query =
	            entityManager.createQuery(
	                    "from Employee",
	                    Employee.class);
		  
	    return query.getResultList();
	}

	@Override
	public List<Employee> findEmployeeBYAge(int empAge) {
		TypedQuery<Employee> query =
	            entityManager.createQuery(
	                    "from Employee where empAge :age",
	                    Employee.class);
		
		query.setParameter("age",+ empAge );

		return query.getResultList();

	}

	@Override
	public List<Employee> findEmployeeBYCity(int empCityCode) {
		TypedQuery<Employee> query =
	            entityManager.createQuery(
	                    "from Employee where empCityCode :empCityCode",
	                    Employee.class);
		
		query.setParameter("empCityCode",+ empCityCode );
		return query.getResultList();

	}

	@Override
	public List<Employee> findEmployeeBYName(String empName) {
		TypedQuery<Employee> query =
	            entityManager.createQuery(
	                    "FROM Student WHERE empName LIKE :data",
	                    Employee.class);

	    query.setParameter("data", "%" + empName + "%");
	    return query.getResultList();
	}

	@Override
	public List<Employee> findEmployeeBYSalary(int empSalary) {
		TypedQuery<Employee> query =
	            entityManager.createQuery(
	                    "from Employee where empSalary:empSalary",
	                    Employee.class);
		
		query.setParameter("empSalary",+ empSalary );
		return query.getResultList();
	}

	@Override
	@Transactional
	public void deleteEmployeeBYId(Integer empId) {
		Employee employee=entityManager.find(Employee.class, empId);
		entityManager.remove(employee);
	}

	@Override
	public Employee updateSalaryBYId(Integer empId) {
		Employee tempEmp =entityManager.find(Employee.class, empId);
		tempEmp.setEmpSalary(75000);
		return tempEmp;
	}

}
