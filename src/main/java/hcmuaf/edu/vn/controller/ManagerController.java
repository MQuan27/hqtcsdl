package hcmuaf.edu.vn.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hcmuaf.edu.vn.model.Feedback;
import hcmuaf.edu.vn.model.PaymentMethod;
import hcmuaf.edu.vn.model.Product;
import hcmuaf.edu.vn.model.ProductType;
import hcmuaf.edu.vn.model.Role;
import hcmuaf.edu.vn.model.User;
import hcmuaf.edu.vn.model.UserOrder;
import hcmuaf.edu.vn.service.FeedBackServices;
import hcmuaf.edu.vn.service.OrderServices;
import hcmuaf.edu.vn.service.ProductServices;
import hcmuaf.edu.vn.service.RoleServices;
import hcmuaf.edu.vn.service.UserServices;
import hcmuaf.edu.vn.util.Util;

@Controller
@RequestMapping("/")
public class ManagerController {
	@Autowired
	UserServices userServices;
	@Autowired
	ProductServices productServices;
	@Autowired
	RoleServices roleServices;
	@Autowired
	OrderServices orderServices;
	@Autowired
	FeedBackServices feedbackServices;

	@RequestMapping(method = RequestMethod.GET)
	public String direction() {
		return "redirect:/manage/manageLogin";
	}

	@RequestMapping("/manageLogin")
	public String setManageLogin(HttpServletRequest request) {

		String returnVal = "";
		String errName = "";
		String errPass = "";
		Role role = null;
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("User: " + userName + "Pass: " + password);
		User userLogin = userServices.getUser(userName);
		// role = roleServices.getRoleByUser(userName);
		String message=null;
		if (userLogin != null) {
			if (userLogin.getPassword().equals(password)) {
				System.out.println(userLogin.getUsername() + "---" + password);
				String name = userLogin.getFullname();
				role = userLogin.getRole();
				if (role.equals(roleServices.getRoleByName(Util.ROLE_ADMIN))
						|| role.equals(roleServices
								.getRoleByName(Util.ROLE_STAFF))) {
					int roleId = role.getRoleId();

					System.out.println("role id :" + roleId);
					request.getSession().setAttribute("name", name);
					request.getSession().setAttribute("roleId", roleId);
					request.getSession().setAttribute("userName", userName);

					returnVal = "back_end/admin-manage";
				} else {
					returnVal = "error/error-role";
					message = "Bạn không có quy�?n truy cập vào trang này";
					request.setAttribute("message", message);
				}
			} else {
				errPass = "Mật khẩu không chính xác";
				request.setAttribute("errPass", errPass);
				returnVal = "redirect:/manage/managelogin";
			}
		} else {
			errName = "Tên đăng nhập không tồn tại";
			request.setAttribute("errName", errName);

			returnVal = "redirect:/manage/managelogin";
		}
		return returnVal;
	}

	@RequestMapping("/manager")
	public String getManagePage(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			url = "back_end/admin-manage";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	/*
	 * Manager FEEDBACK
	 */
	@RequestMapping("/feedBack")
	public String getFeedBack(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			List<Feedback> listFeedback = feedbackServices.getListFeedback();
			request.setAttribute("listFeedback", listFeedback);
			url = "back_end/admin-feedback";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	@RequestMapping("/feedbackDetail")
	public String getFeedbackDetail(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			String id = request.getParameter("id");
			int feedbackId = Integer.parseInt(id);

			Feedback feedback = feedbackServices.getFeedBack(feedbackId);
			request.setAttribute("feedback", feedback);

			url = "back_end/admin-feedback-detail";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	@RequestMapping("/deleteFeedback")
	public String deleteFeedback(HttpServletRequest request) {
		String id = request.getParameter("id");
		int fbId = Integer.parseInt(id);
		System.out.println(id + "----------------");

		feedbackServices.deleteFeedbackById(fbId);

		return "redirect:/manage/feedBack";
	}

	/*
	 * Manager ORDER
	 */
	@RequestMapping("/orderComplete")
	public String getListBill(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			List<UserOrder> listUserOrder = new ArrayList<UserOrder>();
			listUserOrder = orderServices
					.getListOrderUser(Util.STATUS_COMPLETE);
			request.getSession().setAttribute("listUserOrder", listUserOrder);
			url = "back_end/admin-ordercomplete";
		} else {
			url = "redirect:/manage/manageLogin";

		}
		return url;
	}

	@RequestMapping("/orderInComplete")
	public String getOrderComplete(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			List<UserOrder> listUserOrder = new ArrayList<UserOrder>();
			listUserOrder = orderServices
					.getListOrderUser(Util.STATUS_IN_COMPLETE);
			request.getSession().setAttribute("listUserOrder", listUserOrder);
			url = "back_end/admin-orderincomplete";
		} else {
			url = "redirect:/manage/manageLogin";

		}
		return url;
	}

	@RequestMapping("/submitBill")
	public String setSubmitBill(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			String id = request.getParameter("id");
			int orderItemId = Integer.parseInt(id);
			System.out.println("-------------" + orderItemId);
			UserOrder oi = orderServices.getUserOrder(orderItemId);
			oi.setAmount(oi.getAmount());
			oi.setOrderDate(oi.getOrderDate());
			oi.setOrderStatus(orderServices
					.getOrderStatusById(Util.STATUS_COMPLETE));
			oi.setUserOrderId(oi.getUserOrderId());

			orderServices.updateOrderUser(oi);
			url = "redirect:/manage/orderInComplete";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	@RequestMapping("/deleteBillInComp")
	public String deleteBillInComplete(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			String id = request.getParameter("id");
			int userOrderId = Integer.parseInt(id);

			orderServices.deleteUserOrder(userOrderId);

			url = "redirect:/manage/orderInComplete";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	@RequestMapping("/deleteBillComp")
	public String deleteBillComplete(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			String id = request.getParameter("id");
			int userOrderId = Integer.parseInt(id);

			orderServices.deleteUserOrder(userOrderId);

			url = "redirect:/manage/orderComplete";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	/*
	 * Manager PRODUCT
	 */
	@RequestMapping("/product")
	public String getProductPage(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			List<Product> list = null;
			list = productServices.getListProduct();
			request.setAttribute("listProduct", list);

			url = "back_end/admin-product";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	// Add Product Page
	@RequestMapping("/addProductPage")
	public String getAddProduct(Map<String, Object> map,
			HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			map.put("addProduct", new Product());
			List<ProductType> listProType = null;
			listProType = productServices.getlistProType();
			request.setAttribute("listProType", listProType);
			url = "back_end/admin-addproduct";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	// Add Product
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String setAddProduct(@Valid @ModelAttribute("addProduct") Product p,
			BindingResult result, HttpServletRequest request)
			throws UnsupportedEncodingException {

		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			String productName = request.getParameter("productName");
			String description = request.getParameter("description");
			String imagePath = request.getParameter("image");
			System.out.println(imagePath + "------------------------");
			String price = request.getParameter("price");
			Double priDouble = Double.parseDouble(price);
			String proType = request.getParameter("productType");
			int productType = Integer.parseInt(proType);

			// MultipartFile file = file.ge
			// File file = request.getParameter("");
			// System.out.println("image: " + imagePath);
			// Part partImage = request.getPart();

			// // Tải ảnh sản phẩm lên server, đư�?ng dẫn:
			// // "resources/front_end/image/products/"
			// imagePath = File.separator + "resources" + File.separator +
			// "front_end"
			// + File.separator + "image" + File.separator + "products"
			// + File.separator + fileName;
			// File upload = new File(File.separator + "resources" +
			// File.separator
			// + "front_end" + File.separator + "image" + File.separator
			// + "products");
			//
			// System.out.println("Image Path: " + imagePath);

			p = new Product();
			p.setProductName(productName);
			p.setDescription(description);
			// p.setImagePath(imagePath);
			p.setPrice(priDouble);
			ProductType proTy = new ProductType();
			proTy = productServices.getProTypeById(productType);
			p.setProductType(proTy);

			productServices.addProduct(p);

			url = "redirect:/manage/product";

		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	// Delete Product
	@RequestMapping(value = "/delete/Product")
	public String deleteProduct(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			String id = request.getParameter("productId");
			System.out.println("id: " + id);
			int productId = 0;
			productId = Integer.parseInt(id);

			Product pro = productServices.getProductById(productId);
			System.out.println("product ID: " + productId);

			productServices.deleteProductById(pro);
			url = "redirect:/manage/product";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	// Edit Product Page
	@RequestMapping("/editProductPage/Product")
	public String getEditProduct(HttpServletRequest request)
			throws UnsupportedEncodingException {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			String proId = request.getParameter("productId");
			int id = 0;
			id = Integer.parseInt(proId);
			Product p = productServices.getProductById(id);
			// List<Product> listPro = new ArrayList<Product>();
			// listPro.add(p);
			// request.setAttribute("listProduct", listPro);

			request.setAttribute("product", p);

			List<ProductType> pT = new ArrayList<ProductType>();
			pT = productServices.getlistProType();
			request.setAttribute("listProductType", pT);

			url = "back_end/admin-editproduct";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	// Edit Product
	@RequestMapping(value = "/editProduct")
	public String setEditProduct(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			String proId = request.getParameter("productId");
			int productId = Integer.parseInt(proId);
			String namePro = request.getParameter("productName");
			String des = request.getParameter("description");
			String price = request.getParameter("price");
			double pri = Double.parseDouble(price);

			String productType = request.getParameter("productType");
			int id = Integer.parseInt(productType);

			Product pro = new Product();
			pro.setProductId(productId);
			pro.setProductName(namePro);
			pro.setDescription(des);
			pro.setPrice(pri);

			ProductType proTp = new ProductType();
			proTp = productServices.getProTypeById(id);

			pro.setProductType(proTp);

			productServices.editProduct(pro);

			url = "redirect:/manage/product";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	/*
	 * Manager USER
	 */
	// List Staff
	@RequestMapping("/staff")
	public String getListStaff(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			List<User> listStaff = new ArrayList<User>();
			for (User user : userServices.getListUser()) {
				Role role = user.getRole();
				if (Util.ROLE_STAFF.equals(role.getName())) {
					listStaff.add(user);
				}
			}
			request.setAttribute("listStaff", listStaff);
			url = "back_end/admin-staff";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	// Add Staff Page
	@RequestMapping("/addStaffPage")
	public String getAddStaff() {
		return "back_end/admin-addstaff";
	}

	// Add Staff
	@RequestMapping("/addStaff")
	public String setAddStaff(HttpServletRequest request) {

		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phoneNumber");
			String fullName = request.getParameter("fullName");
			String address = request.getParameter("address");

			User user = new User();
			user.setUsername(userName);
			user.setPassword(password);
			user.setEmail(email);
			user.setGender(gender);
			user.setPhoneNumber(phone);
			user.setFullname(fullName);
			user.setDatecreated(new Date());
			user.setAddress(address);
			Role role = new Role();
			role = roleServices.getRoleByName(Util.ROLE_STAFF);
			user.setRole(role);

			userServices.addUser(user);
			url = "redirect:/manage/staff";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	// Delete Staff
	@RequestMapping("/deleteStaff")
	public String deleteStaff(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			String userId = request.getParameter("userId");
			int id = Integer.parseInt(userId);
			userServices.deleteUser(id);
			url = "redirect:/manage/staff";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	// List Customer
	@RequestMapping("/customer")
	public String getListCustomer(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			List<User> listCustommer = new ArrayList<User>();
			for (User user : userServices.getListUser()) {
				Role role = user.getRole();
				if (Util.ROLE_CUSTOMER.equals(role.getName())) {
					listCustommer.add(user);
				}
			}
			request.setAttribute("listStaff", listCustommer);
			url = "back_end/admin-customer";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	// Add Customer Page
	@RequestMapping("/addCustomerPage")
	public String getAddCustomer(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			List<PaymentMethod> payment = new ArrayList<PaymentMethod>();
			payment = userServices.getListPayment();
			request.setAttribute("paymentList", payment);
			url = "back_end/admin-addcustomer";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	// Add Customer
	@RequestMapping("/addCustomer")
	public String setAddCustomer(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phoneNumber");
			String fullName = request.getParameter("fullName");
			String address = request.getParameter("address");
			String payment = request.getParameter("payment");
			int payId = Integer.parseInt(payment);

			User user = new User();
			user.setUsername(userName);
			user.setPassword(password);
			user.setEmail(email);
			user.setGender(gender);
			user.setPhoneNumber(phone);
			user.setFullname(fullName);
			user.setDatecreated(new Date());
			user.setAddress(address);
			Role role = new Role();
			role = roleServices.getRoleByName(Util.ROLE_CUSTOMER);
			user.setRole(role);

			PaymentMethod payMethod = new PaymentMethod();
			payMethod = userServices.getPaymentById(payId);

			user.setPaymentMethod(payMethod);

			userServices.addUser(user);
			url = "redirect:/manage/customer";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	// Delete Customer
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(HttpServletRequest request) {
		String username = (String) request.getSession()
				.getAttribute("userName");
		String url = null;
		System.out.println("user --------- " + username);
		if (username != null) {
			String userId = request.getParameter("userId");
			int id = Integer.parseInt(userId);
			userServices.deleteUser(id);
			url = "redirect:/manage/customer";
		} else {
			url = "redirect:/manage/manageLogin";
		}
		return url;
	}

	@RequestMapping("/ad")
	public String setAd() {
		return "back_end/admin-ad";
	}

	@RequestMapping("/image")
	public String setImage() {
		return "back_end/admin-image";
	}

	@RequestMapping("/backPage")
	public String setExitLogin(HttpServletRequest request) {
		request.getSession().invalidate();
		return "back_end/managelogin";
	}
}
