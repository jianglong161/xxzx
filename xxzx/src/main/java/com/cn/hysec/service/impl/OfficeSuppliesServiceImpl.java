package com.cn.hysec.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hysec.dao.OfficeSuppliesMapper;
import com.cn.hysec.entity.OfficeSupplies;
import com.cn.hysec.service.OfficeSuppliesService;

@Service("officeSuppliesService")
public class OfficeSuppliesServiceImpl implements OfficeSuppliesService {

	@Resource
	private OfficeSuppliesMapper office;
	@Override
	public List<OfficeSupplies> selectAll() {
		// TODO Auto-generated method stub
		return office.selectAll();
	}

}
