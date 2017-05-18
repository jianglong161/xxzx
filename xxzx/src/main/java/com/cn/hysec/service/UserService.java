package com.cn.hysec.service;

import com.cn.hysec.entity.User;
import com.cn.hysec.entity.UserPermission;
import com.cn.hysec.entity.UserRole;
import com.cn.hysec.entity.Role;

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
	/**
	 * 根据username查询用户，之后Shiro会根据查询出来的User的密码来和提交上来的密码进行比对。
	 * @param username
	 * @return
	 */
	public User findUserByUserName(String username);
	/**
	 * 根据username查询该用户的所有角色，用于角色验证。
	 * @param username
	 * @return
	 */
	public Role findRoles(String account);
	/**
	 * 根据username查询他所拥有的权限信息，用于权限判断。
	 * @param username
	 */
	public UserPermission  findPermissions(String username);
	/**
	 * 测试，查询数据库密码
	 */
	public User findPassByAccount(String account);
	/**
	 * 查询用户角色等级
	 */
	public UserRole findUserRoleId(int roleId);
}
