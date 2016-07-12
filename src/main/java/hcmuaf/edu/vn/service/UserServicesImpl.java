package hcmuaf.edu.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hcmuaf.edu.vn.dao.UserDAO;
import hcmuaf.edu.vn.model.PaymentMethod;
import hcmuaf.edu.vn.model.User;

@Transactional
@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserDAO userDAO;

	@Override
	public User getUser(String userName) {
		return userDAO.getUser(userName);
	}

	@Override
	public void editUser(User user) {
		userDAO.editUser(user);
	}

	@Override
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Override
	public List<User> getListUser() {
		return userDAO.getListUser();
	}

	@Override
	public void deleteUser(int userId) {
		userDAO.deleteUser(userId);
	}

	@Override
	public User getUser(int userId) {
		return userDAO.getUser(userId);
	}

	@Override
	public List<PaymentMethod> getListPayment() {
		return userDAO.getListPayment();
	}

	@Override
	public PaymentMethod getPaymentById(int id) {
		return userDAO.getPaymentById(id);
	}

}
