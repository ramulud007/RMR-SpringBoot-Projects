package com.jbk.Validation;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.jbk.entity.Supplier;
@Component
public class SupplierValidation {

	public Map<String, String> ValidateProduct(Supplier supplier){
		
		Map<String, String> errorMap=new HashMap<String, String>();

		if(supplier.getSupplierId()<0) {
			errorMap.put("supplier  Id", "Invalid supplier Id: ");
		}
		
		if(supplier.getSupplierName()==null) {
			errorMap.put("supplier Name", "supplier name not valid: ");
		}
		
		if(supplier.getSupplierCity()==null) {
			errorMap.put("supplier City", "Invalid supplier City:");
		}
		
		if(supplier.getSupplierCountry()==null) {
			errorMap.put("supplier  Country", "Invalid supplier Country:");
		}
		
		if(supplier.getSupplierPostalCode()<0) {
			errorMap.put("supplier  PostalCode", "Invalid supplier PostalCode:");
		}
		
		if(supplier.getSupplierMobileNo()<10) {
			errorMap.put("supplier  MobileNo", "Invalid supplier Mobile No:");
		}
		
		return null;
	}
	
	
	
	
	
}
