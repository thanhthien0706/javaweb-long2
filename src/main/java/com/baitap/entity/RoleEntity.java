package com.baitap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity extends AbstractEntity {
	public static final String AUTHOR_ADMIN = "ROLE_ADMIN";
	public static final String AUTHOR_USER = "ROLE_USER";

	@Column
	private String name;

	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	private List<UserEntity> users;
}
