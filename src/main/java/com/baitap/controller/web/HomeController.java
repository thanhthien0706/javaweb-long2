package com.baitap.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.baitap.dto.BlogDTO;
import com.baitap.dto.MyUser;
import com.baitap.entity.CommentEntity;
import com.baitap.entity.EnumType.StatusComment;
import com.baitap.form.CommentForm;
import com.baitap.repository.BlogRepository;
import com.baitap.repository.CommentRepository;
import com.baitap.service.impl.BlogService;
import com.baitap.service.impl.UserService;

@Controller(value = "homeControllerOfWeb")
public class HomeController {

	@Autowired
	BlogService blogService;

	@Autowired
	UserService userService;

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	BlogRepository blogRepository;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		List<BlogDTO> blogs = blogService.getBlogs("published");

		ModelAndView mav = new ModelAndView("web/home");
		mav.addObject("blogs", blogs);
		return mav;
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accessDenied() {
		return new ModelAndView("redirect:/login?accessDenied");
	}

	@RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
	public ModelAndView seenBlog(@PathVariable Long id) {
		BlogDTO blog = blogService.findOneById(id);

		ModelAndView mav = new ModelAndView("web/blog-seen");
		mav.addObject("blog", blog);
		return mav;
	}

	@RequestMapping(value = "/blog/comment/{id}", method = RequestMethod.POST)
	public ModelAndView createComment(@PathVariable Long id, @ModelAttribute CommentForm commentForm) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		MyUser myUser = (MyUser) authentication.getPrincipal();

		CommentEntity comment = new CommentEntity();
		comment.setContent(commentForm.getContent());
		comment.setStatus(StatusComment.APPROVED);
		comment.setAuthor(userService.findOneById(myUser.getId()));
		comment.setPost(blogRepository.findOne(id));

		commentRepository.save(comment);

		BlogDTO blog = blogService.findOneById(id);

		ModelAndView mav = new ModelAndView("web/blog-seen");
		mav.addObject("blog", blog);
		return mav;
	}
}