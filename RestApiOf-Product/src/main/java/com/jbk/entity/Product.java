package com.jbk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class Product {
	
	@Id
	@Column(unique = true, nullable = false)
	private Long productId;

	@Column(nullable = false, unique = true)
	@NotEmpty
	private String productName;

	@Column(nullable=false)
	private Long supplierId;

	@Column(nullable=false)
	private Long categoryId;

	@Column(nullable = false)
	@Min(1)
	private Integer productQTY;

	@Column(nullable = false)
	@Min(1)
	private Double productPrice;

	public Product() {
	}

	public Product(Long productId, String productName, Long supplierId, Long categoryId, Integer productQTY,
			Double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.productQTY = productQTY;
		this.productPrice = productPrice;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
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

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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
				+ ", categoryId=" + categoryId + ", productQTY=" + productQTY + ", productPrice=" + productPrice + "]";
	}

}
