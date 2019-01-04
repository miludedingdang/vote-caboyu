package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.test.bean.Vote;

@Mapper
public interface VoteMapper {
	
	Boolean save(Vote vote);
	
	Boolean delete(@Param("id")String id);
	
	Boolean update(Vote vote);
	
	List<Vote> list(Vote vote);
	
	Vote query(@Param("id")String id);
}	
