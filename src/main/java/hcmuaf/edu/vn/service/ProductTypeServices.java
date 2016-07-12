package hcmuaf.edu.vn.service;

import java.util.List;

import hcmuaf.edu.vn.entity.ProductType;

public interface ProductTypeServices {
	public List<ProductType> getListProductType();
	public boolean addProductType(ProductType productType);
	public boolean editProductType(ProductType productType);
	public boolean deleteProductTypeById(Integer id);
	public ProductType getProductTypeById(Integer id);
}
