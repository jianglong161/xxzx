package com.cn.hysec.dao;

import java.util.List;

import com.cn.hysec.entity.QueryofficeSupplies;
import com.cn.hysec.entity.User;

public interface QueryofficeSuppliesMapper {
	public List<QueryofficeSupplies> queryOffice(int userId);
}
