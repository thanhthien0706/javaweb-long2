package com.baitap.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.baitap.dto.BlogDTO;
import com.baitap.dto.MyUser;
import com.baitap.entity.PostEntity;
import com.baitap.form.CreateBlogForm;
import com.baitap.service.impl.BlogService;

@Controller
@RequestMapping("/admin/blog")
public class BlogController {

	@Autowired
	BlogService blogService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView getPage() {
		List<BlogDTO> blogs = blogService.getBlogs("all");

		ModelAndView mav = new ModelAndView("admin/blog");
		mav.addObject("blogs", blogs);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView getPageCreate() {
		ModelAndView mav = new ModelAndView("admin/blog-create");
		mav.addObject("action", "create");
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView postPageCreate(@ModelAttribute CreateBlogForm createBlogForm) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser) authentication.getPrincipal();

		createBlogForm.setAuthor_id(myUser.getId());

		PostEntity post = blogService.createBlog(createBlogForm);
		if (post != null) {

		}
		ModelAndView mav = new ModelAndView("admin/blog-create");
		return mav;
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public ModelAndView removeBlog(@PathVariable Long id) {
		blogService.removeBlog(id);
		return new ModelAndView("redirect:/admin/blog");
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editBlog(@PathVariable Long id) {
		BlogDTO blog = blogService.findOneById(id);
		ModelAndView mav = new ModelAndView("admin/blog-create");
		mav.addObject("action", "edit");
		mav.addObject("blog", blog);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView postEditBlog(@PathVariable Long id, @ModelAttribute CreateBlogForm createBlogForm) {
		PostEntity blog = blogService.updateBlog(id, createBlogForm);

		return new ModelAndView("redirect:/admin/blog");
	}
}
