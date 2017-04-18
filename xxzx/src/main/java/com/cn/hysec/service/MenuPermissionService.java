package com.cn.hysec.service;

import com.cn.hysec.entity.MenuPermissions;

public interface MenuPermissionService {
	public MenuPermissions getPermissionByUserId(int userId,int menuId);
}
