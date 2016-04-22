package com.ls.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ls.po.User;


public interface UserMapper {

	User findUserById(int id);
	
	List<User> findUserByName(String name);
	
	List<User> findUsers();
	
	void addUser(User user);
	
	void deleteUser(int id);
	
	void updateUser(User user);
	
	List<User> findUserProductResultMap();
	
	List<User> findUserOrderLazyLoding();
}
