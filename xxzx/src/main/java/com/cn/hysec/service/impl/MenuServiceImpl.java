package com.cn.hysec.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hysec.dao.MenuMapper;
import com.cn.hysec.entity.Menu;
import com.cn.hysec.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Resource  
	private MenuMapper menuDao;
	public List<Menu> selectMenuByUserId(int id) {
		// TODO Auto-generated method stub
		return menuDao.selectMenuByUserId(id);
	}
	public Menu selectById(int id) {
		// TODO Auto-generated method stub
		return menuDao.selectById(id);
	}


}
