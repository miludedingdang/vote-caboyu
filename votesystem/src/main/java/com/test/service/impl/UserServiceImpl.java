package com.test.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.User;
import com.test.mapper.UserMapper;
import com.test.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Boolean save(User user) {
		user.setId(UUID.randomUUID().toString());
		userMapper.save(user);
		return true;
	}

	@Override
	public Boolean delete(String id) {
		userMapper.delete(id);
		return true;
	}

	@Override
	public Boolean update(User user) {
		userMapper.update(user);
		return true;
	}

	@Override
	public List<User> list(User user) {
		List<User> list = userMapper.list(user);
		return list;
	}

	@Override
	public User query(String id) {
		User user = userMapper.query(id);
		return user;
	}
	
}
