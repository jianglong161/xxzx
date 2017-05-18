package com.cn.hysec.entity;
/**
 * 用户角色表
 * @author Still2Almost
 *
 */
public class UserRole {
	private int id; //角色登记
	private int userId;
	private int roleId;
	@Override
	public String toString(){
		return "UserRole [id=" + id + ", "
				
				+ "userId=" + userId + ", "
				+ "userId="+ userId + ", "
				+ "toString()=" + super.toString() + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
}	
