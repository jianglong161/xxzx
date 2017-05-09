package com.cn.hysec.entity;
/**
 * 权限类
 * @author Still2Almost
 *
 */
public class UserPermission {
	private int id;
	private int permissionId;
	private String permissionName;
	private String createTime;
	private String updateTime;
	@Override
	public String toString(){
		return "UserPermission [id=" + id + ", "
				+ "permissionId=" + permissionId + ", "
				+ "permissionName=" + permissionName + ", "
				+ "createTime="+ createTime + ", "
				+ "updateTime=" + updateTime +","
				+ "toString()=" + super.toString() + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	


}
