package com.baitap.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.baitap.dto.BlogDTO;
import com.baitap.service.impl.BlogService;

@Controller(value = "homeControllerOfAdmin")
@RequestMapping("/admin")
public class HomeController {

	@Autowired
	BlogService blogService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		List<BlogDTO> blogs = blogService.getBlogs("all");

		ModelAndView mav = new ModelAndView("admin/blog");
		mav.addObject("blogs", blogs);
		return mav;
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newPage() {
		ModelAndView mav = new ModelAndView("admin/home");
		return mav;
	}
}