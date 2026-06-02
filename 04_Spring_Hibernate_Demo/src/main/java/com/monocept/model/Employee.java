package com.monocept.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Employee")
public class Employee {
	
	@Id
	@Column(name="Employee ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	@Column(name="Employee Name")
	private String empName;
	@Column(name="Employee City")
	private String empCity;
	@Column(name="Employee City Code")
	private int empCityCode;
	@Column(name="Employee Salary")
	private int empSalary;
	@Column(name="Employee Age")
	private int empAge;
	@Column(name="Employee Email")
	private String empMail;
	
	// Now make Constructor and getters/setters
	
	public Employee(String empName, String empCity, int empCityCode, int empSalary, int empAge, String empMail) {
		this.empName = empName;
		this.empCity = empCity;
		this.empCityCode = empCityCode;
		this.empSalary = empSalary;
		this.empAge = empAge;
		this.empMail = empMail;
	}
	public Employee() {}
	public int getEmpId() {
		return empId;
	}
	@Override
	public String toString() {
	    return "Employee [id=" + empId +
	           ", name=" + empName +
	           ", salary=" + empSalary + "]";
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	
	
	
	
	

}
