package com.dto;

import java.sql.Date;
import java.sql.Time;

public class Bill {
	private int billId;
	private String customerName;
	private Date date;
	private Time time;
	private long phoneNumber;
	public Bill(int billId, String customerName, Date date,Time time, long phoneNumber) {
		super();
		this.billId = billId;
		this.customerName = customerName;
		this.date = date;
		this.time = time;
		this.phoneNumber = phoneNumber;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	
}
