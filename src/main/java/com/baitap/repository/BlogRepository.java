package com.baitap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baitap.entity.PostEntity;
import com.baitap.entity.EnumType.StatusPost;

@Repository
public interface BlogRepository extends JpaRepository<PostEntity, Long> {
	List<PostEntity> findByStatus(StatusPost status);
}
