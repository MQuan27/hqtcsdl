package hcmuaf.edu.vn.service;

import java.util.List;

import hcmuaf.edu.vn.entity.PaymentMethod;
import hcmuaf.edu.vn.entity.User;

public interface UserServices {

	public User getUser(int userId);
	
	public User getUser(String userName);

	public void editUser(User user);

	public void addUser(User user);

	public List<User> getListUser();
	
	public void deleteUser(int userId);
	
	public List<PaymentMethod> getListPayment();
	
	public PaymentMethod getPaymentById(int id);

}
