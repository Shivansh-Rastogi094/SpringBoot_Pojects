package com.monocept.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfileResponseDTO {

	private long id;
	private String city;
	private String phone;
	private String email;
	
}
