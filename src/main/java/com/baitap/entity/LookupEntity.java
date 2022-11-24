package com.baitap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_lookup")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LookupEntity extends AbstractEntity {

	@Column
	private String name;

	@Column
	private int code;

	@Column
	private String type;

	@Column
	private int position;
}
