package com.baitap.service;

import java.util.List;

import com.baitap.dto.BlogDTO;
import com.baitap.entity.PostEntity;
import com.baitap.form.CreateBlogForm;

public interface IBlogService {
	PostEntity createBlog(CreateBlogForm createBlogForm);

	List<BlogDTO> getBlogs(String status);

	void removeBlog(Long id);

	BlogDTO findOneById(Long id);

	PostEntity updateBlog(Long id, CreateBlogForm createBlogForm);
}
