package com.jbk.model;

public class Category {

	private long categoryId;
	private String categoryName;
	private Double categoryGst;
	private Double categoryDiscount;
	private Double categoryDeliveryCharge;
	private String categoryDiscription;

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(long categoryId, String categoryName, Double categoryGst, Double categoryDiscount,
			Double categoryDeliveryCharge, String categoryDiscription) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryGst = categoryGst;
		this.categoryDiscount = categoryDiscount;
		this.categoryDeliveryCharge = categoryDeliveryCharge;
		this.categoryDiscription = categoryDiscription;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Double getCategoryGst() {
		return categoryGst;
	}

	public void setCategoryGst(Double categoryGst) {
		this.categoryGst = categoryGst;
	}

	public Double getCategoryDiscount() {
		return categoryDiscount;
	}

	public void setCategoryDiscount(Double categoryDiscount) {
		this.categoryDiscount = categoryDiscount;
	}

	public Double getCategoryDeliveryCharge() {
		return categoryDeliveryCharge;
	}

	public void setCategoryDeliveryCharge(Double categoryDeliveryCharge) {
		this.categoryDeliveryCharge = categoryDeliveryCharge;
	}

	public String getCategoryDiscription() {
		return categoryDiscription;
	}

	public void setCategoryDiscription(String categoryDiscription) {
		this.categoryDiscription = categoryDiscription;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryGst=" + categoryGst
				+ ", categoryDiscount=" + categoryDiscount + ", categoryDeliveryCharge=" + categoryDeliveryCharge
				+ ", categoryDiscription=" + categoryDiscription + "]";
	}

}
