package com.cn.hysec.dao;

import java.util.List;

import com.cn.hysec.entity.Orders;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer oderNumber);
    
    int deleteByUserAndRes(int userId);
    
    int insertOrders(List<Orders> list);
}