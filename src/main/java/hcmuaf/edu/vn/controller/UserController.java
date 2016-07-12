package hcmuaf.edu.vn.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import hcmuaf.edu.vn.model.Feedback;
import hcmuaf.edu.vn.model.OrderItem;
import hcmuaf.edu.vn.model.OrderStatus;
import hcmuaf.edu.vn.model.PaymentMethod;
import hcmuaf.edu.vn.model.Product;
import hcmuaf.edu.vn.model.ProductOrder;
import hcmuaf.edu.vn.model.ProductType;
import hcmuaf.edu.vn.model.Role;
import hcmuaf.edu.vn.model.User;
import hcmuaf.edu.vn.model.UserOrder;
import hcmuaf.edu.vn.service.FeedBackServices;
import hcmuaf.edu.vn.service.OrderServices;
import hcmuaf.edu.vn.service.ProductServices;
import hcmuaf.edu.vn.service.ProductTypeServices;
import hcmuaf.edu.vn.service.RoleServices;
import hcmuaf.edu.vn.service.UserServices;
import hcmuaf.edu.vn.util.Util;

@Controller
@RequestMapping(value = "/")
public class UserController {
	@Autowired
	UserServices userServices;
	@Autowired
	RoleServices roleServices;
	@Autowired
	ProductServices productServices;
	@Autowired
	OrderServices orderServices;
	@Autowired
	FeedBackServices feedBackServices;
	@Autowired
	ProductTypeServices productTypeServices;

	@RequestMapping(value = "/home")
	public String goHome(HttpServletRequest request) {
		return "front_end/home";
	}

	@RequestMapping("/resetPass")
	public String setResetPass() {
		return "front_end/resetpassword";
	}

	@RequestMapping("/feedback")
	public String setFeedbackPage() {
		// String message
		return "front_end/lienhe";
	}

	@RequestMapping("/cart")
	public String setCartPage() {
		return "front_end/cartview";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/chooseProduct")
	public String setProductToCart(HttpServletRequest request) {
		String id = request.getParameter("productId");
		String number = request.getParameter("number");
		int quantity = 1;
		int productId = Integer.parseInt(id);
		int no = Integer.parseInt(number);
		double amount = 0;
		List<ProductOrder> listProductOrder;
		Product prod = productServices.getProductById(productId);
		if (request.getSession().getAttribute("listProductOrder") == null) {
			System.out.println("List is null");
			listProductOrder = new ArrayList<ProductOrder>();
			listProductOrder.add(new ProductOrder(prod, no));
			request.getSession().setAttribute("listProductOrder",
					listProductOrder);
		} else {
			System.out.println("Check Product is exist or not");
			listProductOrder = (List<ProductOrder>) request.getSession()
					.getAttribute("listProductOrder");

			int index = isExist(productId, request);

			if (index == -1)
				listProductOrder.add(new ProductOrder(prod, no));
			else {
				quantity = listProductOrder.get(index).getQuantity() + no;
				listProductOrder.get(index).setQuantity(quantity);
			}
			request.getSession().setAttribute("listProductOrder",
					listProductOrder);
		}
		for (ProductOrder productOrder : listProductOrder) {
			amount += (productOrder.getQuantity() * productOrder.getProduct()
					.getPrice());
			System.out.println("amount" + amount);
		}
		request.getSession().setAttribute("amount", amount);
		return "front_end/cartview";
	}

	@SuppressWarnings("unchecked")
	private int isExist(int productId, HttpServletRequest request) {
		List<ProductOrder> listProductOrder = (List<ProductOrder>) request
				.getSession().getAttribute("listProductOrder");
		int product = listProductOrder.size();
		for (int i = 0; i < product; i++) {
			if (listProductOrder.get(i).getProduct().getProductId() == productId) {
				return i;
			}
		}

		return -1;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/removeProduct")
	public String deleteProductFromCart(HttpServletRequest request) {
		String id = request.getParameter("productId");
		int productId = Integer.parseInt(id);
		double amount = (double) request.getSession().getAttribute("amount");
		double price = 0;
		System.out.println(amount + "--------------------");
		System.out.println("product id + " + id);
		List<ProductOrder> listProOrd = (List<ProductOrder>) request
				.getSession().getAttribute("listProductOrder");
		int index = isExist(productId, request);
		price = listProOrd.get(index).getQuantity()
				* listProOrd.get(index).getProduct().getPrice();
		amount = amount - price;
		request.getSession().setAttribute("amount", amount);
		listProOrd.remove(index);
		request.getSession().setAttribute("listProductOrder", listProOrd);
		return "redirect:/cart";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/payment")
	public String setPaymentForCart(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		List<ProductOrder> listProductOrder = (List<ProductOrder>) request
				.getSession().getAttribute("listProductOrder");
		String url = null;
		if (listProductOrder != null) {
			if (username != null) {
				double amount = (double) request.getSession().getAttribute(
						"amount");
				UserOrder odUser = new UserOrder();
				OrderItem ot = null;
				OrderStatus odStatus = orderServices.getOrderStatusById(1);

				User user = userServices.getUser(username);
				odUser.setAmount(amount);
				odUser.setOrderDate(new Date());
				odUser.setOrderStatus(odStatus);
				odUser.setUser(user);

				Set<OrderItem> orderItem = new HashSet<OrderItem>();
				Iterator<ProductOrder> iterator = listProductOrder.iterator();
				while (iterator.hasNext()) {
					ProductOrder proOrder = iterator.next();

					int quantity = proOrder.getQuantity();

					ot = new OrderItem();
					ot.setOrderQuantity(quantity);
					ot.setProduct(proOrder.getProduct());
					ot.setUserOrder(odUser);

					orderItem.add(ot);
				}

				odUser.setOrderItems(orderItem);
				orderServices.addOrderUser(odUser);
				String message = "Bạn đã đặt hàng thành công!";
				request.getSession().setAttribute("message", message);
				url = "front_end/complete";
			} else {
				List<PaymentMethod> list = userServices.getListPayment();
				request.setAttribute("payment", list);
				url = "front_end/validatecart";
			}
		} else {
			String message = "Vui lòng ch�?n thực đơn trước khi thanh toán!";
			request.setAttribute("message", message);
			url = "front_end/thanks";
		}
		return url;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/validateOrder")
	public String setPayForGuest(HttpServletRequest request) {
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phonenumber");
		String gender = request.getParameter("gender");
		String payment = request.getParameter("payment");
		int paymentId = Integer.parseInt(payment);

		List<ProductOrder> listProductOrder = (List<ProductOrder>) request
				.getSession().getAttribute("listProductOrder");

		String url = null;
		double amount = (double) request.getSession().getAttribute("amount");
		UserOrder odUser = new UserOrder();
		OrderItem ot = null;
		OrderStatus odStatus = orderServices.getOrderStatusById(1);

		User user = new User();
		user.setFullname(fullname);
		user.setEmail(email);
		user.setGender(gender);
		user.setPhoneNumber(phone);
		user.setPaymentMethod(userServices.getPaymentById(paymentId));
		String name = "Guest";
		String pass = "Guest";
		user.setUsername(name);
		user.setPassword(pass);
		user.setDatecreated(new Date());
		user.setRole(roleServices.getRoleByName(Util.ROLE_GUEST));

		odUser.setAmount(amount);
		odUser.setOrderDate(new Date());
		odUser.setOrderStatus(odStatus);
		odUser.setUser(user);

		Set<OrderItem> orderItem = new HashSet<OrderItem>();
		Iterator<ProductOrder> iterator = listProductOrder.iterator();
		while (iterator.hasNext()) {
			ProductOrder proOrder = iterator.next();

			int quantity = proOrder.getQuantity();

			ot = new OrderItem();
			ot.setOrderQuantity(quantity);
			ot.setProduct(proOrder.getProduct());
			ot.setUserOrder(odUser);

			orderItem.add(ot);
		}
		// orderServices.addOrderItem(ot);
		odUser.setOrderItems(orderItem);
		orderServices.addOrderUser(odUser);
		String message = "Bạn đã đặt hàng thành công!";
		request.getSession().setAttribute("message", message);
		url = "front_end/complete";

		return url;
	}

	@RequestMapping("/menu")
	public String setMenuPage(HttpServletRequest request) {
		List<ProductType> listProType = new ArrayList<ProductType>();
		listProType = productServices.getlistProType();
		request.getSession().setAttribute("listType", listProType);

		List<Product> listProduct = new ArrayList<Product>();
		listProduct = productServices.getListProduct();
		request.getSession().setAttribute("listProduct", listProduct);

		return "front_end/menu";
	}

	@RequestMapping("/menuType")
	public String setMenuType(HttpServletRequest request) {
		String id = request.getParameter("producttype");
		System.out.println(id + "---------------------------");
		int prTypeId = Integer.parseInt(id);
		List<Product> listProduct = new ArrayList<Product>();
		ProductType pt = productTypeServices.getProductTypeById(prTypeId);
		listProduct = productServices.getListProduct(pt);
		request.getSession().setAttribute("listProduct", listProduct);

		return "front_end/menu";
	}

	@RequestMapping("/productInfo")
	public String getProductInfo(HttpServletRequest request) {
		String id = request.getParameter("productId");
		int productId = Integer.parseInt(id);

		Product pro = new Product();
		pro = productServices.getProductById(productId);
		request.getSession().setAttribute("product", pro);

		return "front_end/productdetail";
	}

	@RequestMapping("/profile")
	public String getProfileInfo(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		System.out.println("ten dang nhap:" + username);

		List<PaymentMethod> payment = userServices.getListPayment();

		User user = userServices.getUser(username);
		request.setAttribute("user", user);
		request.setAttribute("payment", payment);
		return "profile/profile-edit";
	}

	@RequestMapping("/editProfile")
	public String setEditProfile(HttpServletRequest request) {
		String message = "Thay đổi thông tin thành công";

		String userId = request.getParameter("userId");
		int id = Integer.parseInt(userId);
		String username = request.getParameter("username");
		System.out.println("-------------" + username);
		String passwordNew = request.getParameter("password1");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String phoneNumber = request.getParameter("phoneNumber");
		String fullname = request.getParameter("fullname");
		String payment = request.getParameter("payment");
		int paymentId = Integer.parseInt(payment);

		User user = new User();
		user.setAddress(address);
		user.setDatecreated(new Date());
		user.setEmail(email);
		user.setFullname(fullname);
		user.setPhoneNumber(phoneNumber);
		user.setGender(gender);
		user.setPaymentMethod(userServices.getPaymentById(paymentId));
		user.setPassword(passwordNew);
		user.setUsername(username);
		user.setUserId(id);
		user.setRole(roleServices.getRoleByName(Util.ROLE_CUSTOMER));
		userServices.editUser(user);

		request.setAttribute("message", message);

		return "front_end/thanks";
	}

	@RequestMapping("/back")
	public String setExitLogin(HttpServletRequest request) {
		request.getSession().invalidate();
		return "front_end/home";
	}

	@RequestMapping("/goLogin")
	public String getLoginPage(Map<String, Object> map) {
		return "front_end/login";
	}

	@RequestMapping("/login")
	public String submitLoginForm(HttpServletRequest request) {
		String returnVal = "";
		String errName = "";
		String errPass = "";
		Role role = null;
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("User: " + userName + "Pass: " + password);
		User userLogin = userServices.getUser(userName);
		// role = roleServices.getRoleByUser(userName);

		if (userLogin != null) {
			if (userLogin.getPassword().equals(password)) {
				System.out.println(userLogin.getUsername() + "---" + password);
				String name = userLogin.getFullname();
				role = userLogin.getRole();
				int roleId = role.getRoleId();
				System.out.println("role id :" + roleId);
				request.getSession().setAttribute("name", name);
				request.getSession().setAttribute("roleId", roleId);
				request.getSession().setAttribute("userName", userName);

				returnVal = "front_end/home";
			} else {
				errPass = "Mật khẩu không chính xác";
				request.setAttribute("errPass", errPass);
				returnVal = "redirect:/goLogin";
			}
		} else {
			errName = "Tên đăng nhập không tồn tại";
			request.setAttribute("errName", errName);

			returnVal = "redirect:/goLogin";
		}
		return returnVal;
	}

	@RequestMapping("/registerPage")
	public String setRegisterPage(HttpServletRequest request) {
		List<PaymentMethod> list = new ArrayList<PaymentMethod>();
		list = userServices.getListPayment();
		request.setAttribute("listPayment", list);
		return "front_end/register";
	}

	@RequestMapping("/register")
	public String submitRegisterForm(HttpServletRequest request) {
		String message = "�?ăng ký thành công";

		String errNa = null;
		String errEm = null;
		String url = null;
		String userName = request.getParameter("username");
		System.out.println("user---------" + userName);
		String password = request.getParameter("password");
		String fullName = request.getParameter("fullname");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String payment = request.getParameter("payment");
		int paymentMethod = Integer.parseInt(payment);

		User user = userServices.getUser(userName);
		System.out.println("userName-----------------" + user.getUsername());
		if (user.getUsername() != null || user.getEmail() != null) {
			errNa = "Username đã tồn tại";
			request.setAttribute("errNa", errNa);
			errEm = "Email đã tồn tại";
			// map.put("errEm", errEm);
			request.setAttribute("errEm", errEm);
			url = "redirect:/registerPage";
		} else {
			user = new User();
			user.setUsername(userName);
			user.setPassword(password);
			user.setGender(gender);
			user.setFullname(fullName);
			user.setEmail(email);
			user.setPhoneNumber(phoneNumber);
			user.setDatecreated(new Date());
			user.setAddress(address);

			PaymentMethod paymentMT = new PaymentMethod();
			paymentMT = userServices.getPaymentById(paymentMethod);
			user.setPaymentMethod(paymentMT);

			Role role = new Role();
			role = roleServices.getRoleByName(Util.ROLE_CUSTOMER);
			System.out.println("role " + role);

			user.setRole(role);
			System.out.println("user after: " + user);

			userServices.addUser(user);
			request.setAttribute("message", message);
			url = "front_end/thanks";
		}
		return url;
	}

	@RequestMapping("/getFeedBack")
	public String submitFeedBack(HttpServletRequest request) {
		String fullName = request.getParameter("fullname");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		Feedback f = new Feedback();
		f.setFullname(fullName);
		f.setEmail(email);
		f.setContent(content);
		f.setDateCreated(new Date());
		feedBackServices.addFeedBack(f);
		String message = "Gửi phản hồi thành công";
		request.setAttribute("message", message);
		return "front_end/thanks";

	}
}
