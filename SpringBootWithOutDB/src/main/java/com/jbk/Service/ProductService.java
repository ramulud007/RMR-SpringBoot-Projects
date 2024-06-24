package com.jbk.Service;

import java.util.List;

import com.jbk.Model.Product;

public interface ProductService {

	public boolean saveProduct(Product product);
	public Product getProductById(String productId);
	public List<Product> getAllProducts(Product product);
	public String deleteProductById(String productId);
	public String updateProduct(Product product);
	
	public List<Product> getProductById_ASC();
	public List<Product> getProductByName_DSC();
	public Product getMaxPriceProducts();
	public double getSumOfProductPrice();
	public int getTotalCountOfProducts();
	
	
	
}
