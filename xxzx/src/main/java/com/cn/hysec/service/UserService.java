package com.cn.hysec.service;

import com.cn.hysec.entity.User;

public interface UserService {
	public User login(int userId,String password);
	
	public User getUserById(int userId);
}
