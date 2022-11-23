package com.baitap.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/blog")
public class BlogController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView mav = new ModelAndView("admin/blog");
		return mav;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView getPageCreate() {
		ModelAndView mav = new ModelAndView("admin/blog-create");
		return mav;
	}
}
