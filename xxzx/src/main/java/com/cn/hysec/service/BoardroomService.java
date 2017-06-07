package com.cn.hysec.service;

import java.util.List;

import com.cn.hysec.entity.Boardroom;

public interface BoardroomService {
	/**
	 * 查询全部没有使用的会议室
	 * @return
	 */
	public List<Boardroom> queryAllNoUseRoom();
}
