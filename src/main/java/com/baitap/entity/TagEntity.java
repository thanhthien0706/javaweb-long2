package com.baitap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "tbl_tags")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagEntity extends AbstractEntity {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int frequency;
}
