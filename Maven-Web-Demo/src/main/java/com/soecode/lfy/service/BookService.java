package com.soecode.lfy.service;

import java.util.List;

import com.soecode.lfy.dto.AppointExecution;
import com.soecode.lfy.entity.Book;

/**
 * * 业务接口：站在"使用者"角度设计接口 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 * @author Still2Almost
 *
 */
public interface BookService {
	/**
	 * 查询一本书
	 * @param bookId
	 * @return
	 */
	Book getById(long bookId);
	/**
	 * 查询所有图书
	 * 
	 * @return
	 */
	List<Book> getList();
	/**
	 * 预约图书
	 * 
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	AppointExecution appointExecution(long BookId,long studentId);
}
