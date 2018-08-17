package com.qa.ie2etest.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VehicleDetails {
	
	@Id @GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String regNumber;
	private String make;
	private String colour;
	
	public VehicleDetails() {}
	
	public String getRegNumber() {
		return regNumber;
	}
	
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getColour() {
		return colour;
	}
	
	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "VehicleDetails [regNumber=" + regNumber + ", make=" + make + ", colour=" + colour + "]";
	}
	
	
}
