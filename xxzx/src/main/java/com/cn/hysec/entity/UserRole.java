package com.cn.hysec.entity;
/**
 * 角色关系类
 * @author Still2Almost
 *
 */
public class UserRole {
	private int roleId;
	private String roleName;
	private String createdTime;
	private String updateTime;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "UserRole [roleId=" + roleId + ", "
		+ "roleName=" + roleName + ", "
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
	public String getroleName() {
		return roleName;
	}
	public void setroleName(String roleName) {
		this.roleName = roleName;
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

