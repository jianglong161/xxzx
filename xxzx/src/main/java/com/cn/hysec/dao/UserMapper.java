package com.cn.hysec.dao;

import com.cn.hysec.entity.User;

public interface UserMapper {
    int insert(User user);

    int insertSelective(User record);
    
	User getUserById(int userId);
	
	User login(int userId,String password);
	
}