package com.monocept.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentRequestDto {

	@JsonProperty("department_name")
	@NotBlank(message = "Department name cannot be blank")
	private String departmentName;
	
	@NotBlank(message = "location name cannot be blank")
	private String location;
	
	 @NotEmpty(message = "Department must contain at least one employee")
	 @Valid
	 private List<EmployeeRequestDto> employees;
	
}
