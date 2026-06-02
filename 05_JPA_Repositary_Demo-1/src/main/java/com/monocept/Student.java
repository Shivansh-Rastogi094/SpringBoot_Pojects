package com.monocept;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

	
	@Id
	@Column(name="Student ID")
	private Integer stdId;
	
	private String stdName;
	private Integer stdAge;
	
	public Student() {}
	
	public Student(Integer stdId, String stdName, Integer stdAge) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdAge = stdAge;
	}
	
	@Override
	public String toString() {
	    return "Student [id=" + stdId +
	           ", name=" + stdName +
	           ", age=" + stdAge + "]";
	}
	
}
