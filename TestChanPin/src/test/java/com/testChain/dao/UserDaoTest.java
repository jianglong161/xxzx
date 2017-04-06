package com.testChain.dao;

import java.util.List;

import javax.annotation.security.RunAs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.testChain.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})


public class UserDaoTest {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testSelectByName() throws Exception{
		String userName="zhanglong";
		List<User> list=(List<User>) userDao.selectByName(userName);
		System.out.println(list);
		
		
	}
}
