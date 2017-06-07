package com.cn.hysec.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.cn.hysec.dao.BoardroomMapper;
import com.cn.hysec.entity.Boardroom;
import com.cn.hysec.service.BoardroomService;

public class BoardroomServiceImpl implements BoardroomService{
	@Resource
	private BoardroomMapper boardroomMapper;
	public List<Boardroom> queryAllNoUseRoom() {
		// TODO Auto-generated method stub
		return boardroomMapper.queryAllNoUseRoom();
	}

}
