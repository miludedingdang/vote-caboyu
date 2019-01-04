package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.test.bean.User;

@Mapper
public interface UserMapper {
	
	Boolean save(User user);
	
	Boolean delete(@Param("id")String id);
	
	Boolean update(User user);
	
	List<User> list(User user);
	
	User query(@Param("id")String id);
}	
