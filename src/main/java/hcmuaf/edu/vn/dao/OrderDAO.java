package hcmuaf.edu.vn.dao;

import java.util.List;

import hcmuaf.edu.vn.model.OrderItem;
import hcmuaf.edu.vn.model.OrderStatus;
import hcmuaf.edu.vn.model.UserOrder;

public interface OrderDAO {

	public List<OrderItem> getListOrder();

	public List<UserOrder> getListOrderUser();

	public void addOrderItem(OrderItem orderItem);

	public void addOrderUser(UserOrder orderUser);

	public OrderStatus getOrderStatusById(int id);

	public void updateOrderUser(UserOrder id);

	public OrderItem getOrderItem(int id);

	public UserOrder getUserOrder(int id);
	
	public List<UserOrder> getListOrderUser(int id);

	public void deleteUserOrder(Integer id);
	
	public void mergeOrder(UserOrder order);
}
