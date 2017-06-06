package com.cn.hysec.dao;

import com.cn.hysec.entity.Boardroom;
import java.util.List;

/**
 * 会议室的类	·
 * @author Still2Almost
 *
 */
public interface BoardroomMapper {
	/**
	 * 查询没有使用的会议室
	 * @param boardroom_name
	 * @return
	 */
	public List<Boardroom> queryNoUseRoom(String boardroom_name);
	/**
	 * 查询某个时间段，会议室的情况queryTimeRoom
	 * @param applyTime
	 * @return
	 */
	public List<Boardroom> queryTimeRoom(String applyTime);
	/**
	 * 预定会议室
	 * @param boardroom
	 * @return
	 */
	public int applyRoom(Boardroom boardroom);
	/**
	 * 会议室使用后删除掉
	 * @param applyTime
	 * @return
	 */
	public int deleteRoom(String applyTime);
	
}
