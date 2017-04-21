package com.cn.hysec.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hysec.dao.QueryofficeSuppliesMapper;
import com.cn.hysec.entity.QueryofficeSupplies;
import com.cn.hysec.service.QueryofficeSuppliesService;
@Service("QueryofficeSuppliesService")
public class QueryofficeSuppliesServiceImpl implements QueryofficeSuppliesService{

	@Resource
	private QueryofficeSuppliesMapper queryofficeSuppliesMapper;
	/**
	 * 办公用品登记查询
	 */
	public List<QueryofficeSupplies> queryofficeSupplies(int userId) {
		
		return queryofficeSuppliesMapper.queryOffice(userId);
	}
}
