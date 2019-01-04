package com.test.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.Vote;
import com.test.mapper.VoteMapper;
import com.test.service.VoteService;

@Service
public class VoteServiceImpl implements VoteService{
	
	
	@Autowired
	private VoteMapper voteMapper;
	
	@Override
	public Boolean save(Vote vote) {
		if(vote == null) {
			return false;
		}
		if(StringUtils.isBlank(vote.getId())) {
			vote.setId(UUID.randomUUID().toString());
		}
		voteMapper.save(vote);
		return true;
	}

	@Override
	public Boolean delete(String id) {
		voteMapper.delete(id);
		return true;
	}

	@Override
	public Boolean update(Vote vote) {
		voteMapper.update(vote);
		return true;
	}

	@Override
	public List<Vote> list(Vote vote) {
		List<Vote> list = voteMapper.list(vote);
		return list;
	}

	@Override
	public Vote query(String id) {
		Vote vote = voteMapper.query(id);
		return vote;
	}
	
}
