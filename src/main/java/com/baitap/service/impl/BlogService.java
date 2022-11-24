package com.baitap.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baitap.convert.BlogConvert;
import com.baitap.dto.BlogDTO;
import com.baitap.entity.PostEntity;
import com.baitap.entity.UserEntity;
import com.baitap.entity.EnumType.StatusPost;
import com.baitap.form.CreateBlogForm;
import com.baitap.repository.BlogRepository;
import com.baitap.service.IBlogService;

@Service
public class BlogService implements IBlogService {

	@Autowired
	UserService userService;

	@Autowired
	BlogRepository blogRepository;

	@Autowired
	BlogConvert blogConvert;

	@Override
	public PostEntity createBlog(CreateBlogForm createBlogForm) {
		PostEntity post = new PostEntity();
		post.setTitle(createBlogForm.getTitle());
		post.setContent(createBlogForm.getContent());
		post.setTags(createBlogForm.getTags());

		String statusForm = createBlogForm.getStatus();
		switch (statusForm) {
		case "draft":
			post.setStatus(StatusPost.DRAFT);
			break;
		case "published":
			post.setStatus(StatusPost.PUBLIC);
			break;
		case "unpublished":
			post.setStatus(StatusPost.UNPUBLIC);
			break;
		default:
			post.setStatus(StatusPost.DRAFT);
			break;
		}
		post.setAuthor(userService.findOneById(createBlogForm.getAuthor_id()));
		post.setCreatedTime(new Date());
		post.setUpdatedTime(new Date());

		post = blogRepository.save(post);

		if (post != null) {
			return post;
		}

		return null;
	}

	@Override
	public List<BlogDTO> getBlogs(String status) {
		List<PostEntity> blogs;

		if (status != "all") {
			StatusPost statusPost = null;

			switch (status) {
			case "draft":
				statusPost = StatusPost.DRAFT;
				break;
			case "published":
				statusPost = StatusPost.PUBLIC;
				break;
			case "unpublished":
				statusPost = StatusPost.UNPUBLIC;
				break;
			}

			blogs = blogRepository.findByStatus(statusPost);
		} else {
			blogs = blogRepository.findAll();
		}

		if (blogs != null) {

			return blogConvert.toListDto(blogs);
		}

		return null;
	}

	@Override
	public void removeBlog(Long id) {
		blogRepository.delete(id);
	}

	@Override
	public BlogDTO findOneById(Long id) {
		return blogConvert.toDto(blogRepository.findOne(id));
	}

	@Override
	public PostEntity updateBlog(Long id, CreateBlogForm createBlogForm) {
		PostEntity oldPost = blogRepository.findOne(id);

		if (oldPost != null) {
			oldPost.setTitle(createBlogForm.getTitle());
			oldPost.setContent(createBlogForm.getContent());
			oldPost.setTags(createBlogForm.getTags());
			String statusForm = createBlogForm.getStatus();
			switch (statusForm) {
			case "draft":
				oldPost.setStatus(StatusPost.DRAFT);
				break;
			case "published":
				oldPost.setStatus(StatusPost.PUBLIC);
				break;
			case "unpublished":
				oldPost.setStatus(StatusPost.UNPUBLIC);
				break;
			default:
				oldPost.setStatus(StatusPost.DRAFT);
				break;
			}
			oldPost.setUpdatedTime(new Date());

			oldPost = blogRepository.save(oldPost);

			return oldPost;
		}
		return null;
	}

}
