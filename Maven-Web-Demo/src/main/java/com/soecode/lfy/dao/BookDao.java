package com.soecode.lfy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.soecode.lfy.entity.Book;

public interface BookDao {
	/**
	 * 通过id查询单本图书
	 * @param bookId
	 * @return
	 */
	Book queryById(long bookId);
	/**
	 * 查询所有图书
	 * @param offset 查询的所有位置
	 * @param limit 查询的条数
	 * @return
	 */
	List<Book> queryAll(@Param("offset") int offset,@Param("limit") int limit);
	/**
	 * 减少馆藏数量
	 * @param bookId
	 * @return 如果影响行数等于>1，表示更新的记录行数
	 */
	int reduceNumber(long bookId);
}
