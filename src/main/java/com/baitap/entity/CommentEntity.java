package com.baitap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.baitap.entity.EnumType.StatusComment;
import com.baitap.entity.EnumType.StatusPost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "tbl_comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity extends AbstractEntity {

	@Column(nullable = false)
	private String content;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private StatusComment status;

	@ManyToOne
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private UserEntity author;

	@Column
	private String email;

	@Column
	private String url;

	@ManyToOne
	@JoinColumn(name = "post_id", referencedColumnName = "id")
	private PostEntity post;
}
