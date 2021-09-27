package com.wiley.models;

public class Product {

	private String productName,productId;
	private Double productPrice;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(String productName, String productId, Double productPrice) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.productPrice = productPrice;
	}
	public String getProductName() {
		return this.productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductId() {
		return this.productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Double getProductPrice() {
		return this.productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	
	
}
