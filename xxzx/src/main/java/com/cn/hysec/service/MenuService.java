package com.cn.hysec.service;
import java.util.List;

import com.cn.hysec.entity.Menu;

public interface MenuService {
	
	Menu selectById(int id);
	
	public List<Menu> selectMenuByUserIdAdmin(int id);
	/**
	 *  根据权限查询
	 * @param id
	 * @return
	 */
	public List<Menu> selectMenuByUserIdUser(int id);
}
