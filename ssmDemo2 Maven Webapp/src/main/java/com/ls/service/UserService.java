package com.ls.service;

import java.util.List;

import com.ls.po.User;
import com.ls.po.UserQueryVo;

public interface UserService {

	 User findUserById(Integer id) throws Exception;

	List<User> findUsers() throws Exception;

	void editUser(Integer id, User user) throws Exception;

	void editUserList(UserQueryVo userQueryVo) throws Exception;
}
