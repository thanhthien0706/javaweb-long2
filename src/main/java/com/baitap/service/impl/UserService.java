package com.baitap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baitap.entity.UserEntity;
import com.baitap.repository.UserRepository;
import com.baitap.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserEntity findOneById(Long id) {
		return userRepository.findOneById(id);
	}

}
