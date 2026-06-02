package com.monocept.dto;

public class EmployeeResponseDTO {

	
	private int empAge;
	private String empName, empCity,empMail;
	
	EmployeeResponseDTO(){}

	public EmployeeResponseDTO(int empAge, String empName, String empCity, String empMail) {
		super();
		this.empAge = empAge;
		this.empName = empName;
		this.empCity = empCity;
		this.empMail = empMail;
	}

	public int getEmpAge() {
		return empAge;
	}

	public void setEmpAge(int empAge) {
		this.empAge = empAge;
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

	public String getEmpMail() {
		return empMail;
	}

	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}
}
