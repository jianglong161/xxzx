package com.cn.hysec.dao;

import com.cn.hysec.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
    
	User getUserById(int userId);
	
	User login(int userId,String password);
	/**
	 * 插入用户
	 * @param user
	 * @returninsertSelective
	 */
	int insertUser(User user);
}