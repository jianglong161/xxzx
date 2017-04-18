package com.cn.hysec.dao;

import java.util.List;

import com.cn.hysec.entity.OfficeSupplies;

public interface OfficeSuppliesMapper {
    int deleteByPrimaryKey(Integer resId);

    int insert(OfficeSupplies record);

    int insertSelective(OfficeSupplies record);

    OfficeSupplies selectByPrimaryKey(Integer resId);

    int updateByPrimaryKeySelective(OfficeSupplies record);

    int updateByPrimaryKey(OfficeSupplies record);
    
    List<OfficeSupplies> selectAll();
}