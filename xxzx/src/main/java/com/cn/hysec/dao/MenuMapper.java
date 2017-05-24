package com.cn.hysec.dao;

import java.util.List;

import com.cn.hysec.entity.Menu;

public interface MenuMapper {
    /*int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    int insertSelective(Menu record);*/

    Menu selectById(Integer menuId);

    /*int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);*/
	
	public List<Menu> selectMenuByUserIdAdmin(int id);
	/**
	 *  根据权限查询
	 * @param id
	 * @return
	 */
	public List<Menu> selectMenuByUserIdUser(int id);
	
}