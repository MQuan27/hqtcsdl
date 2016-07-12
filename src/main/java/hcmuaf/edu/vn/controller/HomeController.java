package hcmuaf.edu.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home") 
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String direction() {

		System.out.println("Home hello controller");
		// return "redirect:/organisation/addOrg";
		// return "redirect:/organisation/layout";
		return "redirect:/home";

	}
}
