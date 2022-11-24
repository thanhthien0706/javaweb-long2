package com.baitap.service;

import com.baitap.entity.UserEntity;

public interface IUserService {
	UserEntity findOneById(Long id);
}
