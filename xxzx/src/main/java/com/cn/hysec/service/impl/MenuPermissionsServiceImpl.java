package com.cn.hysec.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hysec.dao.MenuPermissionsMapper;
import com.cn.hysec.entity.MenuPermissions;
import com.cn.hysec.service.MenuPermissionService;

@Service("menuPermissionService")
public class MenuPermissionsServiceImpl implements MenuPermissionService {

	@Resource
	private MenuPermissionsMapper permissiondao;
	
	public MenuPermissions getPermissionByUserId(int userId, int menuId) {
		// TODO Auto-generated method stub
		return permissiondao.getPermissionByUserId(userId, menuId);
	}

}
