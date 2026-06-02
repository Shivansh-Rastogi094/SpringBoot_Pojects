package com.monocept.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Students")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Student ID")
	private long id;
	@Column(name="Student Name")
	@NotNull(message = "Name cannot be null")
	private String fullName;
	@Column(name="Student Age")
	@NotNull(message = "Age cannot be null")
	@Min( value=1, message ="Age should be atleast 1")
	private int age;
	
	
	@OneToOne(
			mappedBy ="student",
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.LAZY 
			)
	private StudentProfile studentProfile;
}
