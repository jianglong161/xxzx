package com.cn.hysec.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hysec.dao.OrdersMapper;
import com.cn.hysec.entity.Orders;
import com.cn.hysec.service.orderServies;

@Service("orderService")
public class OrderServiceImpl implements orderServies {
	@Resource
	private OrdersMapper order;
	public int insertOrders(List<Orders> list) throws Exception{
		// TODO Auto-generated method stub
		int i = 0;
		int userid = list.get(1).getUserId();
		
		order.deleteByUserAndRes(userid);
		i = order.insertOrders(list);
		System.out.println(list.get(1).getUserId()+"-------"+list.get(1).getUserId());
		return i;// order.insertOrders(list);
	}
	public int deleteByUserAndRes(int userId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
