package com.ls.handler;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ls.po.User;
import com.ls.service.UserService;

@Controller
@RequestMapping(value="/restfull")
public class RestFullTestController {

	@Resource
	private UserService userService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
	public User responseJson(@ModelAttribute("id") Integer id) throws Exception{
		User user = userService.findUserById(id);
		
		return user;
	}
}
