package Demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Stud")
public class Student {

	public Student() {	
	}
	public Student(String FName, String SName) {
	    this.FName = FName;
	    this.SName = SName;
	}	
	public int getId() {
		return id;
	}
	
	

	public String getFName() {
		return FName;
	}


	public void setFName(String fName) {
		FName = fName;
	}
	@Override
	public String toString() {
	    return "Student [id=" + id +
	            ", FName=" + FName +
	            ", SName=" + SName + "]";
	}


	@Column(name="Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	@Column(name="FirstName")
	private String  FName;
	@Column(name="SecondName")
	private String  SName;
	
}
