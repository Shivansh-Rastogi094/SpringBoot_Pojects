package com.monocept.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {

	@JsonProperty("employee_name")
	@NotBlank(message = "Name is required")
	private String employeeName;
	
	@NotBlank(message = "Email is required")
	@Email
	private String email;
	
	@NotNull(message = "Salary cannot be blank")
	@Min(value = 1, message = "Salary should be greater than 0")
	private double salary;
}
