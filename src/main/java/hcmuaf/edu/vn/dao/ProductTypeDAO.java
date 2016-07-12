package hcmuaf.edu.vn.dao;

import java.util.List;

import hcmuaf.edu.vn.model.ProductType;

public interface ProductTypeDAO {
	public List<ProductType> getListProductType();

	public boolean addProductType(ProductType productType);

	public boolean editProductType(ProductType productType);

	public boolean deleteProductTypeById(Integer id);

	public ProductType getProductTypeById(Integer id);

}
