package com.dto;

public class BillProduct {
	private String productName;
	private float actualPrice;
	private float retailPrice;
	private float gstPrice;
	private float gstPercent;
	private int Quantity;
	private float totalPrice;
	public BillProduct(String productName, float actualPrice, float retailPrice, float gstPrice, float gstPercent,
			int quantity, float totalPrice) {
		super();
		this.productName = productName;
		this.actualPrice = actualPrice;
		this.retailPrice = retailPrice;
		this.gstPrice = gstPrice;
		this.gstPercent = gstPercent;
		Quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(float actualPrice) {
		this.actualPrice = actualPrice;
	}
	public float getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(float retailPrice) {
		this.retailPrice = retailPrice;
	}
	public float getGstPrice() {
		return gstPrice;
	}
	public void setGstPrice(float gstPrice) {
		this.gstPrice = gstPrice;
	}
	public float getGstPercent() {
		return gstPercent;
	}
	public void setGstPercent(float gstPercent) {
		this.gstPercent = gstPercent;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
}
