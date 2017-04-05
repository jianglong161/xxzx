package com.soecode.lfy.dao;

import org.apache.ibatis.annotations.Param;

import com.soecode.lfy.entity.Appointment;

public interface AppointmentDao {
	/**
	 * 插入预约图书记录
	 * @param bookId
	 * @param studentId
	 * @return 插入的行数
	 */
	int insertAppointment(@Param("bookId") long bookId, 
			@Param("studentId") long studentId);
	/**
	 * 通过主键查询预约图书记录，并且携带图书实体
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	Appointment queryByKeyWithBook(@Param("bookId") long bookId,
			@Param("studentId") long studentId);
	//这里为什么要给方法的参数添加@Param注解呢？是因为该方法有两个或以上的参数，一定要加，不然mybatis识别不了。
}
