package hcmuaf.edu.vn.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hcmuaf.edu.vn.model.ProductType;

@Repository
public class ProductTypeDAOImpl implements ProductTypeDAO {
	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductType> getListProductType() {
		return sessionFactory.getCurrentSession()
				.createCriteria(ProductType.class).list();
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
		return (ProductType) sessionFactory
				.getCurrentSession()
				.createQuery("FROM ProductType pdt WHERE pdt.productTypeId=:id")
				.setInteger("id", id).uniqueResult();

	}
}
