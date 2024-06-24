package com.jbk.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import com.jbk.entity.Product;
import com.jbk.model.FinalProduct;
import com.jbk.model.Product_Category_Supplier;


public interface ProductService {

	public Boolean addProduct(Product product);
	public Product getProductById(Long productId);
	public List<Product> getAllProducts();
	public Boolean deleteProductById(Long productId);
	public Boolean updateProduct(Product product);
	public List<Product> sortProducts(String sortBy,String fieldName);
	public List<Product> getMaxPriceProducts();
	public Double countSumOfProductPrice();
	public Long getTotalCountOfProducts();
	public Product getProductByName(String getProductByName);
	public Boolean deleteProductByName(Product productName);
	public String uploadFile(MultipartFile file);
	public FinalProduct getFinalProductById(Long productId);
	public Product_Category_Supplier getProductWithCategorySupplier(Long productId);
}
