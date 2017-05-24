package com.cn.hysec.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hysec.dao.UserMapper;
import com.cn.hysec.entity.User;
import com.cn.hysec.entity.UserPermission;
import com.cn.hysec.entity.UserRole;
import com.cn.hysec.entity.Role;
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
	/**
	 * 插入用户
	 */
	public int insert(User user) {
		return userDao.insert(user);
	}
	/**
	 * 根据username查询用户，之后Shiro会根据查询出来的User的密码来和提交上来的密码进行比对。
	 * @param username
	 * @return
	 */
	public User findUserByUserName(String username) {
		return userDao.findUserByUserName(username);
	}
	/**
	 * 根据username查询该用户的所有角色，用于角色验证。
	 * @param username
	 * @return
	 */
	public Role findRoles(String account) {
		return userDao.findRoles(account);
	}
	/**
	 * 根据username查询他所拥有的权限信息，用于权限判断。
	 * @param username
	 */
	public UserPermission findPermissions(String username) {
		return userDao.findPermissions(username);
	}
	public User findPassByAccount(String account) {
		// TODO Auto-generated method stub
		return userDao.findPassByAccount(account);
	}
	public UserRole findUserRoleId(int roleId) {
		// TODO Auto-generated method stub
		return userDao.findUserRoleId(roleId);
	}
	
}
