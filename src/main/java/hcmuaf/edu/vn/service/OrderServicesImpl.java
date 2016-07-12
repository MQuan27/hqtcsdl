package hcmuaf.edu.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hcmuaf.edu.vn.dao.OrderDAO;
import hcmuaf.edu.vn.model.OrderItem;
import hcmuaf.edu.vn.model.OrderStatus;
import hcmuaf.edu.vn.model.UserOrder;

@Transactional
@Service
public class OrderServicesImpl implements OrderServices {

	@Autowired
	private OrderDAO orderDAO;

	@Override
	public List<OrderItem> getListOrder() {
		return orderDAO.getListOrder();
	}

	@Override
	public List<UserOrder> getListOrderUser() {
		return orderDAO.getListOrderUser();
	}

	@Override
	public void addOrderItem(OrderItem orderItem) {
		orderDAO.addOrderItem(orderItem);
	}

	@Override
	public void addOrderUser(UserOrder orderUser) {
		orderDAO.addOrderUser(orderUser);
	}

	@Override
	public OrderStatus getOrderStatusById(int id) {
		return orderDAO.getOrderStatusById(id);
	}

	@Override
	public void updateOrderUser(UserOrder orderUser) {
		orderDAO.updateOrderUser(orderUser);
	}

	@Override
	public OrderItem getOrderItem(int id) {
		return orderDAO.getOrderItem(id);
	}

	@Override
	public void deleteUserOrder(Integer id) {
		orderDAO.deleteUserOrder(id);
	}

	@Override
	public UserOrder getUserOrder(int id) {
		return orderDAO.getUserOrder(id);
	}

	@Override
	public List<UserOrder> getListOrderUser(int id) {
		return orderDAO.getListOrderUser(id);
	}

	@Override
	public void mergeOrder(UserOrder order) {
		orderDAO.mergeOrder(order);
	}

}
