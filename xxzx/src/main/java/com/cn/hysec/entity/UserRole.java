package com.cn.hysec.entity;
/**
 * 角色关系类
 * @author Still2Almost
 *
 */
public class UserRole {
	private int roleId;
	private String userName;
	private String createdTime;
	private String updateTime;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserRole [roleId=" + roleId + ", "
		+ "userName=" + userName + ", "
		+ "createdTime=" + createdTime + ", "
		+ "updateTime=" + updateTime + ", "
		+ "toString()=" + super.toString() + "]";
		
}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}

