package com.jbk.model;

public class Supplier {

	private Long supplierId;
	private String supplierName;
	private String supplierCity;
	private Integer supplierPostalCode;
	private String supplierCountry;
	private Long supplierMobileNo;

	public Supplier() {
		// TODO Auto-generated constructor stub
	}

	public Supplier(Long supplierId, String supplierName, String supplierCity, Integer supplierPostalCode,
			String supplierCountry, Long supplierMobileNo) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierCity = supplierCity;
		this.supplierPostalCode = supplierPostalCode;
		this.supplierCountry = supplierCountry;
		this.supplierMobileNo = supplierMobileNo;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierCity() {
		return supplierCity;
	}

	public void setSupplierCity(String supplierCity) {
		this.supplierCity = supplierCity;
	}

	public Integer getSupplierPostalCode() {
		return supplierPostalCode;
	}

	public void setSupplierPostalCode(Integer supplierPostalCode) {
		this.supplierPostalCode = supplierPostalCode;
	}

	public String getSupplierCountry() {
		return supplierCountry;
	}

	public void setSupplierCountry(String supplierCountry) {
		this.supplierCountry = supplierCountry;
	}

	public Long getSupplierMobileNo() {
		return supplierMobileNo;
	}

	public void setSupplierMobileNo(Long supplierMobileNo) {
		this.supplierMobileNo = supplierMobileNo;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierCity="
				+ supplierCity + ", supplierPostalCode=" + supplierPostalCode + ", supplierCountry=" + supplierCountry
				+ ", supplierMobileNo=" + supplierMobileNo + "]";
	}

}
