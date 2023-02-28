package com.car_parking_management.dto;

public class Location {
	private String location;
	private int [][] lots;
	private float chargePerDay;
	private int parkingId;
	public Location(String location, int[][] lots, float chargePerDay, int parkingId) {
		super();
		this.location = location;
		this.lots = lots;
		this.chargePerDay = chargePerDay;
		this.parkingId = parkingId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int[][] getLots() {
		return lots;
	}
	public void setLots(int[][] lots) {
		this.lots = lots;
	}
	public float getChargePerDay() {
		return chargePerDay;
	}
	public void setChargePerDay(float chargePerDay) {
		this.chargePerDay = chargePerDay;
	}
	public int getParkingId() {
		return parkingId;
	}
	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
	}
	
}
