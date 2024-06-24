package com.jbk.model;

import com.jbk.entity.Product;

public class Product_Category_Supplier {

	private Product product;
	private Category category;
	private Supplier supplier;

	public Product_Category_Supplier() {
		// TODO Auto-generated constructor stub
	}

	public Product_Category_Supplier(Product product, Category category, Supplier supplier) {
		super();
		this.product = product;
		this.category = category;
		this.supplier = supplier;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "Product_Category_Supplier [product=" + product + ", category=" + category + ", supplier=" + supplier
				+ "]";
	}

}
