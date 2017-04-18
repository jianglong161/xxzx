package com.cn.hysec.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hysec.dao.UserMapper;
import com.cn.hysec.entity.User;
import com.cn.hysec.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource  
	private UserMapper userDao;
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userDao.getUserById(userId);
	}
	public User login(int userId,String password) {
		return userDao.login(userId,password);
	}
}
