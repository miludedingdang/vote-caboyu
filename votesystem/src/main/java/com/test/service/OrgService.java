package com.test.service;

import java.util.List;

import com.test.bean.Org;

public interface OrgService {

	Boolean save(Org org);
	
	Boolean delete(String id);
	
	Boolean update(Org org);
	
	List<Org> list(Org org);
	
	Org query(String id);
}
