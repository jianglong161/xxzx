package com.cn.hysec.service;

import java.util.List;

import com.cn.hysec.entity.Orders;

public interface orderServies {
	int insertOrders(List<Orders> list) throws Exception;
	
	int deleteByUserAndRes(int userId) throws Exception;
}
