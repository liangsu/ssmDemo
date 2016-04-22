package com.ls.handler;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ls.po.User;
import com.ls.service.UserService;

@Controller
public class JsonTestController {

	@Resource
	private UserService userService;
	
	@RequestMapping(value="/requestJson")
	public @ResponseBody List<User> requestJson(@RequestBody User user) throws Exception{
		System.out.println(user);
		
		List<User> users = userService.findUsers();
		
		return users;
	}
	
	@RequestMapping(value="/responseJson")
	@ResponseBody
	public User responseJson() throws Exception{
		List<User> users = userService.findUsers();
		
		return users.get(1);
	}
	
	@RequestMapping(value="/responseJson2")
	public void responseJson2(HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("asdflkjaskldfj");
	}
}
