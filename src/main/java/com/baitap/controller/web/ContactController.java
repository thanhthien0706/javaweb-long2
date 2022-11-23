package com.baitap.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "contactControllerOfWeb")
@RequestMapping("/contact")
public class ContactController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView getPage() {
		ModelAndView mav = new ModelAndView("web/contact");
		return mav;
	}

}
