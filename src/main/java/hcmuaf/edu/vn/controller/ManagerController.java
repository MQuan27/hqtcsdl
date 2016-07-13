package hcmuaf.edu.vn.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/manage")
public class ManagerController {

	@RequestMapping(method = RequestMethod.GET)
	public String direction() {
		return "redirect:/manage/manageLogin";
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
