package com.cn.hysec.dao;

import com.cn.hysec.entity.User;
import com.cn.hysec.entity.UserPermission;
import com.cn.hysec.entity.UserRole;
import com.cn.hysec.entity.Role;

public interface UserMapper {
    int insert(User user);

    int insertSelective(User record);
    
	User getUserById(int userId);
	
	User login(int userId,String password);
	/**
	 * 根据username查询用户，之后Shiro会根据查询出来的User的密码来和提交上来的密码进行比对。
	 * @param username
	 * @return
	 */
	public Role findRoles(String account);
	/**
	 * 根据username查询他所拥有的权限信息，用于权限判断。
	 * @param username
	 */
	public UserPermission  findPermissions(String account);
	
	/**
	 * 测试，查询数据库密码
	 */
	public User findPassByAccount(String account);
	/**
	 * 
	 */
	public User findUserByUserName(String account);
	/**
	 * 查询用户角色登记
	 */
	public UserRole findUserRoleId(int roleId);
}