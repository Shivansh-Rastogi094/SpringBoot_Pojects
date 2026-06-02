package com.monocept.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {

	
	@NotNull(message = "Name cannot be null")
	@JsonProperty("full_name")
	private String fullName;
	@NotNull(message = "Age cannot be null")
	@Min( value=1, message ="Age should be atleast 1")
	private int age;
	@Valid
	@NotNull
	private StudentProfileRequestDTO studentProfile;
}
