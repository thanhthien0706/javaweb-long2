package com.baitap.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getLogin() {
		ModelAndView mav = new ModelAndView("web/login");
		return mav;
	}
}
