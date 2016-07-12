package hcmuaf.edu.vn.service;

import java.util.List;

import hcmuaf.edu.vn.entity.Product;
import hcmuaf.edu.vn.entity.ProductType;

public interface ProductServices {

	public List<Product> getListProduct();
	
	public List<Product> getListProduct(ProductType id);

	public Product getProductById(Integer id);

	public void addProduct(Product product);

	public void deleteProductById(Product pro);

	public void editProduct(Product pro);

	public List<ProductType> getlistProType();
	
	public ProductType getProTypeById(int id);

}
