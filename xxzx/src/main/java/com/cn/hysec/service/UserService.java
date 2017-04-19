package com.cn.hysec.service;

import com.cn.hysec.entity.User;

public interface UserService {
	/**
	 * 登录
	 * @param userId
	 * @param password
	 * @return
	 */
	public User login(int userId,String password);
	/**
	 * 得到用户id
	 * @param userId
	 * @return
	 */
	public User getUserById(int userId);
	/**
	 * 插入用户信息
	 * @param user
	 * @return
	 */
	public int insert(User user);
}
