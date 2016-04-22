package com.ls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ls.exception.CustomException;
import com.ls.mapper.UserMapper;
import com.ls.po.User;
import com.ls.po.UserCustomer;
import com.ls.po.UserQueryVo;
import com.ls.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper userMapper;

	public User findUserById(Integer id) throws CustomException {
		User user = userMapper.findUserById(id);
		if(user == null){
			throw new CustomException("你查找的用户不存在!");
		}
		return user;
	}

	public List<User> findUsers() throws Exception {
		return userMapper.findUsers();
	}

	public void editUser(Integer id, User user) throws Exception {
		if(id != null && id > 0){
			userMapper.updateUser(user);
		}
	}

	public void editUserList(UserQueryVo userQueryVo) throws Exception {
		if(userQueryVo != null && userQueryVo.getUserCustomers() != null){
			for (UserCustomer userCustomer : userQueryVo.getUserCustomers()) {
				User user = new User();
				BeanUtils.copyProperties(userCustomer, user);
				userMapper.updateUser(user);
			}
		}
	}
	
}
