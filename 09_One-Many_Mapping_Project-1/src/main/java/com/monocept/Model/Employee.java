package com.monocept.Model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Employee Id")
	private long id;
	
	@Column(name="Employee Name")
	@JsonProperty("EmpName")
	@NotBlank(message = "Name is required")
	private String employeeName;
	
	@Column(name="Employee Email", unique = true)
	@NotBlank(message = "Email is required")
	@JsonProperty("EmpMail")
	private String email;
	
	@Column(name="Employee Salary")
	@JsonProperty("EmpSal")
	@NotNull(message = "Salary cannot be blank")
	@Min(value = 1, message = "Salary should be greater than 0")
	private double salary;
	
	@ManyToOne
	@JoinColumn(name="Department Id")
	private Department department;
}
