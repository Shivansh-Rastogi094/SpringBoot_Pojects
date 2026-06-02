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
	private int id;
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
	
	@Override
	public String toString() {
	    return "Employee [id=" + id +
	           ", name=" + empName +
	           ", salary=" + empSalary + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpCity() {
		return empCity;
	}
	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}
	public int getEmpCityCode() {
		return empCityCode;
	}
	public void setEmpCityCode(int empCityCode) {
		this.empCityCode = empCityCode;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getEmpMail() {
		return empMail;
	}
	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	
	
	
	
	

}
