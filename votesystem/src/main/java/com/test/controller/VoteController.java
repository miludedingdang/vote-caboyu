package com.test.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.bean.Org;
import com.test.bean.Vote;
import com.test.service.OrgService;
import com.test.service.VoteService;

@Controller
public class VoteController {
	
	@Autowired
	private VoteService voteService;
	@Autowired
	private OrgService orgService;
	
	@RequestMapping("goAdd")
	public String goAdd(Vote vote) {
		return "votesand";
	}
	
	@RequestMapping("votesave")
	public String save(HttpServletRequest req,Vote vote) {
		vote.setId(UUID.randomUUID().toString());
		voteService.save(vote);
		List<Vote> voteList = voteService.list(vote);
		req.setAttribute("list", voteList);
		if(vote !=null ) {
			req.setAttribute("name", vote.getName());
		}
		if(vote !=null) {
			req.setAttribute("orgName", vote.getOrgName());
		}
		return "voteslist";
	}

	@RequestMapping("votedelete")
	public String delete(HttpServletRequest req,String id) {
		voteService.delete(id);
		List<Vote> voteList = voteService.list(null);
		req.setAttribute("list", voteList);
		return "voteslist";
	}

	@RequestMapping("voteupdate")
	public String update(HttpServletRequest req,Vote vote) {
		voteService.update(vote);
		List<Vote> voteList = voteService.list(vote);
		req.setAttribute("list", voteList);
		if(vote !=null ) {
			req.setAttribute("name", vote.getName());
		}
		if(vote !=null) {
			req.setAttribute("orgName", vote.getOrgName());
		}
		return "voteslist";
	}

	@RequestMapping("votelist")
	public String list(HttpServletRequest req,Vote vote) {
		List<Vote> voteList = voteService.list(vote);
		req.setAttribute("list", voteList);
		if(vote !=null ) {
			req.setAttribute("name", vote.getName());
		}
		if(vote !=null) {
			req.setAttribute("orgName", vote.getOrgName());
		}
		return "voteslist";
	}

	@RequestMapping("votequery")
	public String query(HttpServletRequest req,String id) {
		Vote vote = voteService.query(id);
		req.setAttribute("vote", vote);
		List<Org> orgList = orgService.list(null);
		req.setAttribute("orgs", orgList);
		return "votesedit";
	}
	
	@RequestMapping("votestart")
	public String votestart(HttpServletRequest req,String id) {
		Vote vote = voteService.query(id);
		vote.setVoteNumber(vote.getVoteNumber()+1);
		voteService.update(vote);
		List<Vote> voteList = voteService.list(null);
		req.setAttribute("list", voteList);
		return "voteslist";
	}
	
	@RequestMapping("voteresrt")
	public String votesrest(HttpServletRequest req,Vote vote) {
		List<Vote> voteList = voteService.list(null);
		req.setAttribute("list", voteList);
		req.setAttribute("name", vote.getName());
		req.setAttribute("orgName", vote.getOrgName());
		return "voteslist";
	}
}
