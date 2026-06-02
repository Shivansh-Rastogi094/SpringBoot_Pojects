package com.monocept.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {

	private long id;
	@JsonProperty("full_name")
	private String fullNmae;
	private int age;
	private StudentProfileResponseDTO profile;
}
