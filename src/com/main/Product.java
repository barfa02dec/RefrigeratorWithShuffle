package com.main;

public class Product{

	private String productName;
	private int productSize;
	public Product() {
	}
	public Product(String productName, int productSize) {
		super();
		this.productName = productName;
		this.productSize = productSize;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductSize() {
		return productSize;
	}
	public void setProductSize(int productSize) {
		this.productSize = productSize;
	}
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productSize=" + productSize + "]";
	}
	
}
