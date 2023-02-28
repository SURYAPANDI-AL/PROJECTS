package com.car_parking_management.dto;

import java.time.LocalDate;
import java.time.LocalTime;

//brand,register no,owner,contact no,in time,out time,parking charge,parking number,status.
public class Car {
	private String brand;
	private String registerNumber;
	private String owner;
	private long contactnumber;
	private LocalTime inTime;
	private LocalDate inDate;
	private LocalTime outTime;
	private LocalDate outDate;
	private int parkingNumber;
	public Car(String brand, String registerNumber, String owner,long contactnumber, LocalTime inTime,
			LocalDate inDate, LocalTime outTime, LocalDate outDate, int parkingNumber) {
		super();
		this.brand = brand;
		this.registerNumber = registerNumber;
		this.owner = owner;
		this.contactnumber = contactnumber;
		this.inTime = inTime;
		this.inDate = inDate;
		this.outTime = outTime;
		this.outDate = outDate;
		this.parkingNumber = parkingNumber;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getRegisterNumber() {
		return registerNumber;
	}
	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public long getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(long contactnumber) {
		this.contactnumber = contactnumber;
	}
	public LocalTime getInTime() {
		return inTime;
	}
	public void setInTime(LocalTime inTime) {
		this.inTime = inTime;
	}
	public LocalDate getInDate() {
		return inDate;
	}
	public void setInDate(LocalDate inDate) {
		this.inDate = inDate;
	}
	public LocalTime getOutTime() {
		return outTime;
	}
	public void setOutTime(LocalTime outTime) {
		this.outTime = outTime;
	}
	public LocalDate getOutDate() {
		return outDate;
	}
	public void setOutDate(LocalDate outDate) {
		this.outDate = outDate;
	}
	public int getParkingNumber() {
		return parkingNumber;
	}
	public void setParkingNumber(int parkingNumber) {
		this.parkingNumber = parkingNumber;
	}
}
