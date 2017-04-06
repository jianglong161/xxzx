package com.testChain.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.RunAs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.testChain.entity.User;

 
public class UserDaoTest extends UserDaoBase{
	@Autowired
	private UserDao userDao;
	
	@Test
	public void testSelectByName() throws Exception{
		String userName="zhanglong";
		User user= userDao.selectByName(userName);
		System.out.println("-------------------"+user);
		
		
	}
}
