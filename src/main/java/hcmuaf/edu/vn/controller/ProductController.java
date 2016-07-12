package hcmuaf.edu.vn.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hcmuaf.edu.vn.entity.Product;
import hcmuaf.edu.vn.service.ProductServices;

@Controller
@RequestMapping(value = "/")
public class ProductController {
	@Autowired
	ProductServices productServices;

	@RequestMapping(value = "menu/show", method = RequestMethod.GET)
	public String listProduct(Map<String, Object> map, ModelMap model) {
		 List<Product> products = productServices.getListProduct();
		model.addAttribute("products",products);

		return "front_end/menu";

	}
	
}
