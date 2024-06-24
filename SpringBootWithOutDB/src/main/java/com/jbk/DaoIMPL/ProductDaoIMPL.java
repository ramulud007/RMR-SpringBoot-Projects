package com.jbk.DaoIMPL;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jbk.Dao.ProductDao;
import com.jbk.Model.Product;

@Repository
public class ProductDaoIMPL implements ProductDao {

	List<Product> list = new ArrayList<>();
	
	
	@Override
	public boolean saveProduct(Product product) {
	
		boolean isExist = false;

		for (Product dbproduct : list) {
		if (dbproduct.getProductName().equalsIgnoreCase(product.getProductName())) {

		isExist = true;
			break;
			}
		}
		
		if(!isExist) {
			
			list.add(product);
			
			return true;
		}else {
			return false;
		}

	}

	@Override
	public Product getProductById(String productId) {
	Product product=null;
		List<Product> list=new ArrayList<>();
		for(Product dbproductId:list) {
			if(dbproductId.getProductId().equals(productId)) {
				product=dbproductId;
				continue;
				
			}else { 
				return null;
				
			}
			
			}
		return product;
				
		}
		


	@Override
	public List<Product> getAllProducts(Product product) {
		List<Product> list=new ArrayList<>();	
		Product productlist=null;
		
		for(Product listofAllproduct : list) {
			if(listofAllproduct!=null) {
					
			list.add(productlist);
			continue;
			}
			else
			break;
				
			} 
		
		return list;
	}

	@Override
	public String deleteProductById(String productId) {
		
		List<Product> list=new ArrayList<>();
		boolean productIdIsexist=true;
		for(Product deletproductById:list) {
		if(deletproductById.getProductId().equals(productId)) {
		productIdIsexist=true;
			boolean add = list.remove(productId);
			continue;
			
		}else {
			return null;
		}
		
		}
		return "Product deleted Successfully...";
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
