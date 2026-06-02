package com.monocept.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Patients")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private LocalDate birthdate;
	private String name;
	private String gender;
	@Column(unique =true, nullable=false)
	private String email;

	@OneToOne
	private Insurance insurance;
	
	@OneToMany(mappedBy = "patient")
	private List<Appointment> appointment;
 }
