package com.dto;

public class Product {

	int productId; 
	String productName;
	float actualPrice;
	float retailPrice;
	float gstPrice;
	float gstPercent;
	int stock;
	int user_id;
	
	public Product(int productId, String productName, float actualPrice, float retailPrice, float gstPrice,
			float gstPercent, int stock, int user_id) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.actualPrice = actualPrice;
		this.retailPrice = retailPrice;
		this.gstPrice = gstPrice;
		this.gstPercent = gstPercent;
		this.stock = stock;
		this.user_id = user_id;
	}
	public Product(String productName, float actualPrice, float retailPrice, float gstPrice, float gstPercent,
			int stock, int user_id) {
		super();
		this.productName = productName;
		this.actualPrice = actualPrice;
		this.retailPrice = retailPrice;
		this.gstPrice = gstPrice;
		this.gstPercent = gstPercent;
		this.stock = stock;
		this.user_id = user_id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
