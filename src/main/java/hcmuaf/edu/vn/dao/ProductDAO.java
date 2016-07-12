package hcmuaf.edu.vn.dao;

import java.util.List;

import hcmuaf.edu.vn.model.Product;
import hcmuaf.edu.vn.model.ProductType;

public interface ProductDAO {
	
	public List<Product> getListProduct();
	
	public List<Product> getListProduct(ProductType id);
	
	public Product getProductById(Integer id);
	
	public void addProduct(Product product);
	
	public void deleteProductById(Product pro);
	
	public void editProduct(Product pro);
	
	public List<ProductType> getlistProType();
	
	public ProductType getProTypeById(int id);
}
