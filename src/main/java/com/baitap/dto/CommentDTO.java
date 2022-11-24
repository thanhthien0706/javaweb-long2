package com.baitap.dto;

import com.baitap.entity.UserEntity;
import com.baitap.entity.EnumType.StatusComment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO extends AbstractSDTO {
	private String content;
	private StatusComment status;
	private UserDTO author;
	private String email;
	private String url;
	private BlogDTO blog;
}
