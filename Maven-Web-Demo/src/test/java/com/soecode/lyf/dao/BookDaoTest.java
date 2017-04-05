package com.soecode.lyf.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lfy.dao.BookDao;
import com.soecode.lfy.entity.Book;
import com.soecode.lyf.BaseTest;

public class BookDaoTest extends BaseTest{
	@Autowired
	//@Resource
	private BookDao bookDao;
	
	@Test
	public void testQueryById() throws Exception {
		long bookId = 1000;
		Book book = bookDao.queryById(bookId);
		System.out.println(book);
	}
	@Test
	public void testQueryAll() throws Exception {
		List<Book> books = bookDao.queryAll(0, 4);
		for (Book book : books) {
			System.out.println(book);
		}
	}

	@Test
	public void testReduceNumber() throws Exception {
		long bookId = 1000;
		int update = bookDao.reduceNumber(bookId);
		System.out.println("update=" + update);
	}
}
