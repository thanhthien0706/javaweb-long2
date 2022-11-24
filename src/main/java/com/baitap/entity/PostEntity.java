package com.baitap.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.baitap.entity.EnumType.StatusPost;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "tbl_post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity extends AbstractEntity {

	@Column(nullable = false)
	private String title;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;

	@Column
	private String tags;

	@Column(nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private StatusPost status;

	@OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
	private List<CommentEntity> comments;

	@ManyToOne
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private UserEntity author;
}
