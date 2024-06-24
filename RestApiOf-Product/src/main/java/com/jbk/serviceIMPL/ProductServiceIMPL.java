package com.jbk.serviceIMPL;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import com.jbk.Validation.ProductValidation;
import com.jbk.dao.ProductDao;
import com.jbk.entity.Product;
import com.jbk.model.Category;
import com.jbk.model.Charges;
import com.jbk.model.FinalProduct;
import com.jbk.model.Product_Category_Supplier;
import com.jbk.model.Supplier;
import com.jbk.service.ProductService;

@Service
public class ProductServiceIMPL implements ProductService {

	@Autowired
	private ProductDao dao;

	@Autowired
	private ProductValidation productValidation;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Boolean addProduct(Product product) {
		String id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
		product.setProductId(Long.parseLong(id));
		Boolean isAdded = dao.addProduct(product);
		return isAdded;
	}

	@Override
	public List<Product> getAllProducts() {
		return dao.getAllProducts();
	}

	@Override
	public Boolean updateProduct(Product product) {
		return dao.updateProduct(product);
	}

	@Override
	public Boolean deleteProductById(Long productId) {
		return dao.deleteProductById(productId);
	}

	@Override
	public Product getProductById(Long productId) {
		return dao.getProductById(productId);
	}

	@Override
	public List<Product> sortProducts(String sortBy, String fieldName) {
		return dao.sortProducts(sortBy, fieldName);
	}

	@Override
	public List<Product> getMaxPriceProducts() {
		return dao.getMaxPriceProducts();
	}

	@Override
	public Double countSumOfProductPrice() {
		return dao.countSumOfProductPrice();
	}

	@Override
	public Long getTotalCountOfProducts() {
		return dao.getTotalCountOfProducts();
	}

	@Override
	public Product getProductByName(String producName) {
		return dao.getProductByName(producName);
	}

	@Override
	public Boolean deleteProductByName(Product productName) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> readExcel(String filePath) {

		List<Product> list = new ArrayList<>();

		try {
			// FileInputStream fis=new FileInputStream(filePath);

			Workbook workbook = new XSSFWorkbook(filePath);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.rowIterator();

			while (rows.hasNext()) {
				Row row = (Row) rows.next();

				if (row.getRowNum() == 0) {
					continue;
				}

				Product product = new Product();
				String id = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new java.util.Date());
				product.setProductId(Long.parseLong(id));

				Iterator<Cell> cells = row.cellIterator();
				while (cells.hasNext()) {
					Cell cell = (Cell) cells.next();

					int columnIndex = cell.getColumnIndex();

					switch (columnIndex) {
					case 0:
						product.setProductName(cell.getStringCellValue());
						break;
					case 1:
						product.setProductPrice(cell.getNumericCellValue());
						break;

					case 2:
						product.setProductQTY((int) cell.getNumericCellValue());
						break;

					case 3:

						product.setCategoryId((long) (cell.getNumericCellValue()));
						break;

					case 4:
						product.setSupplierId((long) cell.getNumericCellValue());
						break;

					}

				}
				list.add(product);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public String uploadFile(MultipartFile file) {

		String msg = null;
		try {

			String path = "src/main/resources/";
			String name = file.getOriginalFilename();

			FileOutputStream fos = new FileOutputStream(path + File.separator + name);

			byte[] data = file.getBytes();
			fos.write(data);

			List<Product> list = readExcel(path + File.separator + name);

			msg = dao.productUploadFile(list);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public Product_Category_Supplier getProductWithCategorySupplier(Long productId) {

		Product_Category_Supplier pcs=new Product_Category_Supplier();
		
		Product product = getProductById(productId);
		pcs.setProduct(product);
		
			
		// If the Servers is Live then below category and Supplier will run.
		// If the servers is terminated then the output will come null,it can not throw any Exception.
		// because of try catch.
		
		try {
		
			Category category=restTemplate.getForObject("http://localhost:8081/category/get-Category-By-Id-ms/"+product.getCategoryId(), Category.class);
			pcs.setCategory(category);
			
		}catch(ResourceAccessException e) {
			pcs.setCategory(null);
			//Now the server will give output null
		}
		
		try {
			
			Supplier supplier=restTemplate.getForObject("http://localhost:8083/supplier/get-Supplier-By-Id-ms/"+product.getSupplierId(), Supplier.class);
			pcs.setSupplier(supplier);
			
		} catch (ResourceAccessException e) {
			pcs.setSupplier(null);
		}
		
		
		
		return pcs;
	}

	
	
	
	@Override
	public FinalProduct getFinalProductById(Long productId) {

		Product product = dao.getProductById(productId);
		
		FinalProduct finalProduct = null;
		Category category=null;
		Supplier supplier=null;
		
		try {
		
			category=restTemplate.getForObject("http://localhost:8081/category/get-Category-By-Id-ms/"+product.getCategoryId(), Category.class);
		
		} catch (ResourceAccessException e) {
			return finalProduct;
		}
		
		
		try {
			
		supplier=restTemplate.getForObject("http://localhost:8083/supplier/get-Supplier-By-Id-ms/"+product.getSupplierId(), Supplier.class);

		} catch (ResourceAccessException e) {
			
		}
		
		if(product!=null) {
			
			finalProduct=new FinalProduct();
		
		// get Gst
		Double gst = category.getCategoryGst();
		
		//get Calculate Gst Amount.
		Double gstAmount = product.getProductPrice() * category.getCategoryGst()/100;

		//Calculate Discount percentage
		Double discountpercent = category.getCategoryDiscount();
		
		 //Calculate DiscountAmount
		Double DiscountAmount = product.getProductPrice() * category.getCategoryDiscount()/100;

		Double productPrice = product.getProductPrice();

		Double deliveryCharges = category.getCategoryDeliveryCharge();

		Charges charges = new Charges();
		charges.setDeliveryCharge(category.getCategoryDeliveryCharge());
		charges.setGstAmount(gstAmount);
		charges.setGst(gst);
		
		finalProduct.setProductId(productId);
		finalProduct.setProductName(product.getProductName());
		finalProduct.setProductQTY(product.getProductQTY());
		finalProduct.setCategoryId(category);
		finalProduct.setSupplierId(supplier);
		finalProduct.setDiscountAmount(DiscountAmount);
		finalProduct.setDiscountPercentage(discountpercent);
		finalProduct.setCharges(charges);

		finalProduct.setProductPrice(productPrice);

		finalProduct.setProductFinalPrice(productPrice + gstAmount + deliveryCharges - DiscountAmount);
		
		
		}
		return finalProduct;
	}

}
