package com.monocept.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="Student Profile")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentProfile {
	
	@Id
	@Column(name="Student Profile Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="Student Email",unique = true)
	@NotNull(message = "Email cannot be null")
	private String email;
	@Column(name="Student City")
	@NotNull(message = "City cannot be null")
	private String city;
	@Column(name="Student Phone")
	@NotNull(message = "Phone cannot be null")
	@Pattern(
		    regexp = "^[0-9]{10}$",
		    message = "Phone number must contain exactly 10 digits"
		)
	private String phone;
	
	@OneToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="Student Id",nullable = false,unique = true)
	private Student student;
}
