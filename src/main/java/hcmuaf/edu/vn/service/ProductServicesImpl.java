package hcmuaf.edu.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hcmuaf.edu.vn.dao.ProductDAO;
import hcmuaf.edu.vn.model.Product;
import hcmuaf.edu.vn.model.ProductType;

@Transactional
@Service
public class ProductServicesImpl implements ProductServices {
	@Autowired
	ProductDAO productDAO;

	@Override
	public List<Product> getListProduct() {
		return productDAO.getListProduct();
	}

	@Override
	public Product getProductById(Integer id) {
		return productDAO.getProductById(id);
	}

	@Override
	public void addProduct(Product product) {
		productDAO.addProduct(product);
	}

	@Override
	public void deleteProductById(Product pro) {
		productDAO.deleteProductById(pro);
	}

	@Override
	public void editProduct(Product pro) {
		productDAO.editProduct(pro);
	}

	@Override
	public List<ProductType> getlistProType() {
		return productDAO.getlistProType();
	}

	@Override
	public ProductType getProTypeById(int id) {
		return productDAO.getProTypeById(id);
	}

	@Override
	public List<Product> getListProduct(ProductType id) {
		return productDAO.getListProduct(id);
	}
}
