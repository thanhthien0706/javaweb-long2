package com.baitap.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.baitap.convert.CommentConvert;
import com.baitap.dto.BlogDTO;
import com.baitap.dto.CommentDTO;
import com.baitap.entity.CommentEntity;
import com.baitap.entity.EnumType.StatusComment;
import com.baitap.repository.CommentRepository;

@Controller
@RequestMapping("/admin/comment")
public class CommentController {

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	CommentConvert commentConvert;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView getPage() {
		List<CommentEntity> commentsEntity = commentRepository.findAll();

		List<CommentDTO> comments = commentConvert.toListDto(commentsEntity);

		ModelAndView mav = new ModelAndView("admin/comment");
		mav.addObject("comments", comments);
		return mav;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView updateComent(@PathVariable Long id, @RequestParam String status) {
		StatusComment statusComment = null;
		if (status.equals("unapproved")) {
			statusComment = StatusComment.UNAPPROVED;
		} else {
			statusComment = StatusComment.APPROVED;
		}

		CommentEntity oldComment = commentRepository.findOne(id);
		oldComment.setStatus(statusComment);

		commentRepository.save(oldComment);

		return new ModelAndView("redirect:/admin/comment");
	}

}
