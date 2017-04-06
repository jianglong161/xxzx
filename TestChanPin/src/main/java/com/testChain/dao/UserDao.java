package com.testChain.dao;

import com.testChain.entity.User;

public interface UserDao {
	/**
	 * 插入账户
	 * @param user
	 * @return
	 */
	int insert(User user);
	/**
	 * 根据id来查找客户
	 * @param userId
	 * @return
	 */
	User selectById(int userId);
	/**
	 * 更新账户的信息
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	/**
	 * 根据用户账号来查找
	 * @param userName
	 * @return
	 */
	User selectByName(String userName);
	/**
	 * 根据用户邮箱来查找
	 * @param userEmail
	 * @return
	 */
	User selectByEmail(String userEmail);
	
}
