package com.monocept.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {

	private long id;
	@JsonProperty("employee_name")
	private String employeeName;
	
	private String email;
	
	private double salary;
}
