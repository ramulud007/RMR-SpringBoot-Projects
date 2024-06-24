package com.jbk.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.Model.Product;
import com.jbk.ServiceIMPL.ProductServiceIMPL;

@RestController
@RequestMapping("/product")
public class ProductRestController {

	@Autowired
	private ProductServiceIMPL service;
	
	@PostMapping("/save-product")
	public String saveProduct(@RequestBody Product product) {
	boolean isAdded = service.saveProduct(product);
	
	if(isAdded) {
		return "saved";
	}
	return "Product Already Exist..";
	}
	

	@GetMapping("/getAllProductsList")
	public Object getAllProducts(@RequestBody Product product){
		
	List<Product> list = service.getAllProducts(product);
	
	if(list.isEmpty()) {
		return "no data available";
	}else {
		return list;
	}
		
	}
	
	@GetMapping("/getproductById/{Id}")
	public Object getProductById(@PathVariable("Id") String Id) {
		Product product = service.getProductById(Id);
		if(product!=null) {
			return product;
		}else {
			return "product not available";
		}
	}
	
	@DeleteMapping("/deleteProductById/{Id}")
	public String deleteProductById(@PathVariable ("Id") String Id) {
		String deleteProductId = service.deleteProductById(Id);
		if(deleteProductId!=null) {
			return "Product deleted";
		}
		else {
			return "ProductId not available";
		}
	}
	
}
