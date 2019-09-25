package com.tts.studentExample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// 2
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private Float gpa;
	private Boolean isInClub;
	
	public Student() {};
	
	public Student(String name, Float gpa, Boolean isInClub) {
		this.name = name;
		this.gpa = gpa;
		this.isInClub = isInClub;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getGpa() {
		return gpa;
	}
	public void setGpa(Float gpa) {
		this.gpa = gpa;
	}
	public Boolean getIsInClub() {
		return isInClub;
	}
	public void setIsInClub(Boolean isInClub) {
		this.isInClub = isInClub;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", gpa=" + gpa + ", isInClub=" + isInClub + "]";
	}

}
