package com.cn.hysec.service;
import java.util.List;

import com.cn.hysec.entity.Menu;

public interface MenuService {
	List<Menu>  selectMenuByUserId(int id);
	Menu selectById(int id);
}
