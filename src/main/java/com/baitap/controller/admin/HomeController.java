package com.baitap.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfAdmin")
@RequestMapping("/admin")
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newPage() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}
}