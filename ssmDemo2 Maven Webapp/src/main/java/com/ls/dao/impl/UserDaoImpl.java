package com.ls.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ls.dao.UserDao;
import com.ls.po.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	public User findUserById(int id) {
		SqlSession sqlSession = super.getSqlSession();
		User user = sqlSession.selectOne("test.findUserById", 1);
		return user;
	}

}
