package com.jbk.ServiceIMPL;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Dao.ProductDao;
import com.jbk.Model.Product;
import com.jbk.Service.ProductService;

@Service
public class ProductServiceIMPL implements ProductService {

	@Autowired
	private ProductDao dao;
	
	List<Product> list=new ArrayList<>();
	
	@Override
	public boolean saveProduct(Product product) {
						
		String productId = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
		//product.setProductId(Long.parseLong(productId));
		//this is used to convert long into String
		
		product.setProductId(productId);
		boolean isAdded = dao.saveProduct(product);
		return isAdded;
	}

	@Override
	public Product getProductById(String productId) {
		return dao.getProductById(productId);
		
	}

	@Override
	public List<Product> getAllProducts(Product product) {
	List<Product> list = dao.getAllProducts(product);
	return list;
	}

	@Override
	public String deleteProductById(String productId) {
		return dao.deleteProductById(productId);
		
	}

	@Override
	public String updateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductById_ASC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductByName_DSC() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getMaxPriceProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getSumOfProductPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalCountOfProducts() {
		// TODO Auto-generated method stub
		return 0;
	}


}
