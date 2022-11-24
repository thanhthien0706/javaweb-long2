package com.baitap.convert;

import org.springframework.stereotype.Component;

import com.baitap.dto.UserDTO;
import com.baitap.entity.UserEntity;

@Component
public class UserConvert {
	public UserDTO toDTO(UserEntity userEntity) {
		UserDTO dto = new UserDTO();
		dto.setId(userEntity.getId());
		dto.setUsername(userEntity.getUsername());
		dto.setEmail(userEntity.getEmail());
		dto.setProfile(userEntity.getProfile());
		dto.setCreatedTime(userEntity.getCreatedTime());

		return dto;
	}
}
