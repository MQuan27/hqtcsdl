package hcmuaf.edu.vn.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hcmuaf.edu.vn.model.PaymentMethod;
import hcmuaf.edu.vn.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getUser(String userName) {
		return (User) sessionFactory.getCurrentSession()
				.createQuery("FROM User us WHERE us.username=:userName")
				.setString("userName", userName).uniqueResult();
	}

	@Override
	public void editUser(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		sessionFactory.getCurrentSession().flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getListUser() {
		List<User> list = sessionFactory.getCurrentSession()
				.createCriteria(User.class).list();
		return list;

	}

	@Override
	public void deleteUser(int id) {
		sessionFactory.getCurrentSession()
				.createQuery("DELETE User us WHERE us.userId=:id")
				.setInteger("id", id).executeUpdate();
	}

	@Override
	public User getUser(int id) {
		return (User) sessionFactory.getCurrentSession()
				.createQuery("FROM User us WHERE us.userId=:id")
				.setInteger("id", id).uniqueResult();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PaymentMethod> getListPayment() {
		List<PaymentMethod> list = sessionFactory.getCurrentSession()
				.createCriteria(PaymentMethod.class).list();
		return list;
	}

	@Override
	public PaymentMethod getPaymentById(int id) {
		return (PaymentMethod) sessionFactory
				.getCurrentSession()
				.createQuery(
						"FROM PaymentMethod pm WHERE pm.paymentMethodId=:id")
				.setInteger("id", id).uniqueResult();
	}

}
