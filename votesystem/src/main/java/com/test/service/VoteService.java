package com.test.service;

import java.util.List;

import com.test.bean.Vote;

public interface VoteService {

	Boolean save(Vote vote);
	
	Boolean delete(String id);
	
	Boolean update(Vote vote);
	
	List<Vote> list(Vote vote);
	
	Vote query(String id);
}
