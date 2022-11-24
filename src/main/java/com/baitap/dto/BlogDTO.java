package com.baitap.dto;

import java.util.List;

import com.baitap.entity.EnumType.StatusPost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO extends AbstractSDTO {
	private String title;
	private String content;
	private String tags;
	private StatusPost status;
	private List<CommentDTO> comments;
	private UserDTO author;
}
