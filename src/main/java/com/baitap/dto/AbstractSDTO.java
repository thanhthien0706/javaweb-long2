package com.baitap.dto;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;

import lombok.Data;

@Data
public class AbstractSDTO {
	private Long id;
	private Date createdTime;
	private Date updatedTime;
}
