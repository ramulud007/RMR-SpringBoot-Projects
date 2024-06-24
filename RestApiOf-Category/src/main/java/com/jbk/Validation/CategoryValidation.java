package com.jbk.Validation;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.jbk.entity.Category;

@Component
public class CategoryValidation {

	
	public Map<String, String> ValidateCategory(Category category){
		
		Map<String, String> errorMap=new HashMap<String, String>();
		
		if(category.getCategoryId()<0) {
			errorMap.put("Category Id", "Please Enter valid Catagory Id");
		}
		
		if(category.getCategoryName()==null) {
			errorMap.put("category Name", "Please Enter Category Name");
		}
		
		if(category.getCategoryGst()<0) {
			errorMap.put("category  Gst", "Invalid category Gst");
		}
		
		if(category.getCategoryDiscription().equals("") || category.getCategoryDiscription()==null) {
			errorMap.put("category  Disc", "Please Enter Category discription");
		}
		
		if(category.getCategoryDiscount()<0) {
			errorMap.put("category  Discount", "please enter valid details..");
		}
		
		return null;
	}
	
	
	
	
	
}
