package hcmuaf.edu.vn.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hcmuaf.edu.vn.entity.Product;
import hcmuaf.edu.vn.entity.ProductType;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getListProduct() {
		List<Product> list = sessionFactory.getCurrentSession()
				.createQuery("FROM Product").list();
		return list;
	}

	@Override
	public Product getProductById(Integer id) {
		return (Product) sessionFactory.getCurrentSession()
				.createQuery("FROM Product pd WHERE pd.productId=:id")
				.setInteger("id", id).uniqueResult();
	}

	@Override
	public void addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void deleteProductById(Product pro) {
		sessionFactory.getCurrentSession().delete(pro);
	}

	@Override
	public void editProduct(Product pro) {
		sessionFactory.getCurrentSession().update(pro);
		sessionFactory.getCurrentSession().flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductType> getlistProType() {
		List<ProductType> list = sessionFactory.getCurrentSession()
				.createCriteria(ProductType.class).list();
		return list;
	}

	@Override
	public ProductType getProTypeById(int id) {
		return (ProductType) sessionFactory.getCurrentSession()
				.createQuery("FROM ProductType pd WHERE pd.productTypeId=:id")
				.setInteger("id", id).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getListProduct(ProductType id) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product pd WHERE pd.productType=:id")
				.setParameter("id", id).list();
	}

}
