package com.monocept.DTO;



import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfileRequestDTO {

	
	@NotNull(message = "Email cannot be null")
	private String email;
	@NotNull(message = "City cannot be null")
	private String city;
	@NotNull(message = "Phone cannot be null")
	@Pattern(
		    regexp = "^[0-9]{10}$",
		    message = "Phone number must contain exactly 10 digits"
		)
	private String phone;
	
}
