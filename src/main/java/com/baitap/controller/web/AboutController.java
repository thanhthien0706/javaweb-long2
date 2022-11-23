package com.baitap.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/about")
public class AboutController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView mav = new ModelAndView("web/about");
		return mav;
	}
}
