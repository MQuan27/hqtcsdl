package hcmuaf.edu.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hcmuaf.edu.vn.dao.ProductTypeDAO;
import hcmuaf.edu.vn.model.ProductType;

@Service
@Transactional
public class ProductTypeServicesImpl implements ProductTypeServices {
	@Autowired
	ProductTypeDAO productTypeDAO;

	@Override
	public List<ProductType> getListProductType() {
		return productTypeDAO.getListProductType();
	}

	@Override
	public boolean addProductType(ProductType productType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editProductType(ProductType productType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProductTypeById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductType getProductTypeById(Integer id) {
		return productTypeDAO.getProductTypeById(id);
	}

}
