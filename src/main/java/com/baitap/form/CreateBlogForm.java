package com.baitap.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBlogForm {
	private String title;
	private String content;
	private String tags;
	private String status;
	private Long author_id;
}
