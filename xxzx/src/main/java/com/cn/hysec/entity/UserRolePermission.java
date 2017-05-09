package com.cn.hysec.entity;
/**
 * 角色权限类
 * @author Still2Almost
 *
 */
public class UserRolePermission {
	private int id;	//主键
	private int roleId;	//角色id
	private int permissionId; //权限id
	@Override
	public String toString(){
		return "UserRolePermission [id=" + id + ", "
				+ "roleId=" + roleId + ", "
				+ "permissionId=" + permissionId + ", "
				+ "toString()=" + super.toString() + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	
	
}
