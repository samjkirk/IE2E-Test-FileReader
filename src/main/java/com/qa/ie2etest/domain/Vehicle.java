package com.qa.ie2etest.domain;

public class Vehicle {
	
	private String regNumber;
	private String make;
	private String colour;
	
	public Vehicle() {}
	
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
