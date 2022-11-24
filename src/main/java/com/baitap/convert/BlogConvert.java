package com.baitap.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baitap.dto.BlogDTO;
import com.baitap.dto.UserDTO;
import com.baitap.entity.PostEntity;

@Component
public class BlogConvert {

	@Autowired
	CommentConvert commentConvert;

	@Autowired
	UserConvert userConvert;

	public BlogDTO toDto(PostEntity post) {
		BlogDTO dto = new BlogDTO();
		dto.setId(post.getId());
		dto.setTitle(post.getTitle());
		dto.setContent(post.getContent());
		dto.setTags(post.getTags());
		dto.setStatus(post.getStatus());
		dto.setComments(commentConvert.toListDto(post.getComments()));
		dto.setAuthor(userConvert.toDTO(post.getAuthor()));
		dto.setCreatedTime(post.getCreatedTime());
		dto.setUpdatedTime(post.getUpdatedTime());

		return dto;
	}

	public List<BlogDTO> toListDto(List<PostEntity> posts) {
		List<BlogDTO> dtos = new ArrayList<>();

		for (PostEntity post : posts) {
			dtos.add(toDto(post));
		}

		return dtos;
	}
}
