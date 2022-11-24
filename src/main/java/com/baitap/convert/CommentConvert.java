package com.baitap.convert;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baitap.dto.CommentDTO;
import com.baitap.entity.CommentEntity;

@Component
public class CommentConvert {

	@Autowired
	UserConvert userConvert;

	@Autowired
	BlogConvert blogConvert;

	public CommentDTO toDto(CommentEntity commentEntity) {
		CommentDTO dto = new CommentDTO();
		dto.setId(commentEntity.getId());
		dto.setContent(commentEntity.getContent());
		dto.setStatus(commentEntity.getStatus());
		dto.setAuthor(userConvert.toDTO(commentEntity.getAuthor()));
		dto.setEmail(commentEntity.getEmail());
		dto.setUrl(commentEntity.getUrl());
		dto.setCreatedTime(commentEntity.getCreatedTime());

		return dto;
	}

	public List<CommentDTO> toListDto(List<CommentEntity> comments) {
		List<CommentDTO> dtos = new ArrayList<>();

		for (CommentEntity comment : comments) {
			dtos.add(toDto(comment));
		}
		return dtos;
	}

}
