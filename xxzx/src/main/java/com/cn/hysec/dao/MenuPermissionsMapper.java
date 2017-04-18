package com.cn.hysec.dao;

import com.cn.hysec.entity.MenuPermissions;

public interface MenuPermissionsMapper {

	MenuPermissions getPermissionByUserId(int userId,int menuId);  
    
}