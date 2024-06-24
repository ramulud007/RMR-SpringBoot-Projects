package com.jbk.Model;

public class Product {

	private String productId;
	private String productName;
	private Long supplierId;
	private Long categiryId;
	private Integer productQTY;
	private Double productPrice;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productId, String productName, Long supplierId, Long categiryId, Integer productQTY,
			Double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplierId = supplierId;
		this.categiryId = categiryId;
		this.productQTY = productQTY;
		this.productPrice = productPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getCategiryId() {
		return categiryId;
	}

	public void setCategiryId(Long categiryId) {
		this.categiryId = categiryId;
	}

	public Integer getProductQTY() {
		return productQTY;
	}

	public void setProductQTY(Integer productQTY) {
		this.productQTY = productQTY;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", supplierId=" + supplierId
				+ ", categiryId=" + categiryId + ", productQTY=" + productQTY + ", productPrice=" + productPrice + "]";
	}
	
	
	
}
