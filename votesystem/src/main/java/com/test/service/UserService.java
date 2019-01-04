package com.test.service;

import java.util.List;

import com.test.bean.User;

public interface UserService {

	Boolean save(User user);
	
	Boolean delete(String id);
	
	Boolean update(User user);
	
	List<User> list(User user);
	
	User query(String id);
}
