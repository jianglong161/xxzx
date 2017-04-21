package com.cn.hysec.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cn.hysec.entity.QueryofficeSupplies;

public interface QueryofficeSuppliesService {
	public List<QueryofficeSupplies> queryofficeSupplies(int userId);
}
