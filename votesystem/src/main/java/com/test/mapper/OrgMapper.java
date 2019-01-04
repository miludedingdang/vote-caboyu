package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.test.bean.Org;

@Mapper
public interface OrgMapper {
	
	Boolean save(Org org);
	
	Boolean delete(@Param("id")String id);
	
	Boolean update(Org org);
	
	List<Org> list(Org org);
	
	Org query(@Param("id")String id);
}	
