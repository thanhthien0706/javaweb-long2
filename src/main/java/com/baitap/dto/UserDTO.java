package com.baitap.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends AbstractSDTO {
	private String username;
	private String password;
	private String email;
	private String profile;
	private Long role_id;
}
