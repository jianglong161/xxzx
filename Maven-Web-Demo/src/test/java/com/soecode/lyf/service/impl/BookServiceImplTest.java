package com.soecode.lyf.service.impl;

import java.security.KeyStore.PrivateKeyEntry;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lfy.dto.AppointExecution;
import com.soecode.lfy.exception.AppointException;
import com.soecode.lfy.service.BookService;
import com.soecode.lyf.BaseTest;

public class BookServiceImplTest extends BaseTest{
	@Autowired
	private BookService bookService;
	@Test
	public void  testAppoint(){
		long BookId = 1001;
		long studentId = 12345678910L;
		AppointExecution appointException=bookService.appointExecution(BookId, studentId);
		System.out.println("---------:"+appointException);
	}
}
