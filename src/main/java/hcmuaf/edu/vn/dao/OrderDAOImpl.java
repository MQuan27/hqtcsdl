package hcmuaf.edu.vn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hcmuaf.edu.vn.entity.OrderItem;
import hcmuaf.edu.vn.entity.OrderStatus;
import hcmuaf.edu.vn.entity.User;
import hcmuaf.edu.vn.entity.UserOrder;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderItem> getListOrder() {
		List<OrderItem> list = sessionFactory.getCurrentSession()
				.createQuery("FROM OrderItem").list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserOrder> getListOrderUser() {
		List<UserOrder> list = sessionFactory.getCurrentSession()
				.createQuery("FROM UserOrder").list();
		return list;
	}

	@Override
	public void addOrderItem(OrderItem orderItem) {
		sessionFactory.getCurrentSession().save(orderItem);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void addOrderUser(UserOrder orderUser) {
		sessionFactory.getCurrentSession().save(orderUser);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public OrderStatus getOrderStatusById(int id) {
		return (OrderStatus) sessionFactory.getCurrentSession()
				.createQuery("From OrderStatus os Where os.orderStatusId=:id")
				.setInteger("id", id).uniqueResult();
	}

	@Override
	public void updateOrderUser(UserOrder orderUser) {
		sessionFactory.getCurrentSession().update(orderUser);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public OrderItem getOrderItem(int id) {
		return (OrderItem) sessionFactory.getCurrentSession()
				.createQuery("FROM OrderItem uo WHERE uo.orderItemId=:id")
				.setInteger("id", id).uniqueResult();
	}

	@Override
	public UserOrder getUserOrder(int id) {
		return (UserOrder) sessionFactory.getCurrentSession()
				.createQuery("FROM UserOrder uo WHERE uo.userOrderId=:id")
				.setInteger("id", id).uniqueResult();
	}

	@Override
	public void deleteUserOrder(Integer id) {
		sessionFactory
				.getCurrentSession()
				.createQuery(
						"DELETE FROM UserOrder uo WHERE uo.userOrderId=:id")
				.setInteger("id", id).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserOrder> getListOrderUser(int id) {
		return sessionFactory
				.getCurrentSession()
				.createQuery(
						"FROM UserOrder uo WHERE uo.orderStatus.orderStatusId=:id")
				.setInteger("id", id).list();
	}

	public void mergeOrder(UserOrder order) {
		User user = order.getUser();
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unused")
		User mergenUser = (User) session.merge(user);
		session.persist(user);
	}

}
