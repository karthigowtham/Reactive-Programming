package io.highway.source;

import java.io.Serializable;


public class Vehicle implements Serializable {
    
    private static final long serialVersionUID = -6415713305955411683L;
    
    private String  carPlateNumber;
    private Integer speed;
    private String  color;
    
    public Vehicle() {
    	
    }
    
    public Vehicle(String carPlateNumber,Integer speed, String  color) {
    	this.carPlateNumber = carPlateNumber;
    	this.speed = speed;
    	this.color = color;
    }
    
    public String getCarPlateNumber() {
		return carPlateNumber;
	}
	public void setCarPlateNumber(String carPlateNumber) {
		this.carPlateNumber = carPlateNumber;
	}
	public Integer getSpeed() {
		return speed;
	}
	public void setSpeed(Integer speed) {
		this.speed = speed;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	} 
	
	@Override
	public String toString() {
		return String.format("[Number=%s, speed=%s, color=%s]",	carPlateNumber, speed, color);
	}
	
    
    	
}

