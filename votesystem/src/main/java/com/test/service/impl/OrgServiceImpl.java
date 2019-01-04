package com.test.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.Org;
import com.test.mapper.OrgMapper;
import com.test.service.OrgService;

@Service
public class OrgServiceImpl implements OrgService{
	
	
	@Autowired
	private OrgMapper orgMapper;
	
	@Override
	public Boolean save(Org org) {
		org.setId(UUID.randomUUID().toString());
		orgMapper.save(org);
		return true;
	}

	@Override
	public Boolean delete(String id) {
		orgMapper.delete(id);
		return true;
	}

	@Override
	public Boolean update(Org org) {
		orgMapper.update(org);
		return true;
	}

	@Override
	public List<Org> list(Org org) {
		List<Org> list = orgMapper.list(org);
		return list;
	}

	@Override
	public Org query(String id) {
		Org org = orgMapper.query(id);
		return org;
	}
	
}
