package com.test.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.bean.User;
import com.test.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("usersave")
	public String save(HttpServletRequest req,User user) {
		user.setId(UUID.randomUUID().toString());
		User userQuery = new User();
		userQuery.setUserName(user.getUserName());
		List<User> list = userService.list(userQuery);
		if(list != null && list.size() > 0) {
			req.setAttribute("message", "用户名已经注册请您重新注册");
			return "regist";
		}
		userService.save(user);
		return "login";
	}

	@RequestMapping("userdelete")
	public String delete(String id) {
		userService.delete(id);
		return "";
	}

	@RequestMapping("userupdate")
	public String update(User user) {
		userService.update(user);
		return "";
	}

	@RequestMapping("userlist")
	public String list(User user) {
		List<User> list = userService.list(user);
		return "";
	}

	@RequestMapping("userquery")
	public String query(String id) {
		User user = userService.query(id);
		return "";
	}
	
}
