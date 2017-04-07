package com.testChain.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.testChain.dao.UserDaoBase;
import com.testChain.dto.ResultSinIn;
import com.testChain.vo.UserSignInForm;

public class UserServiceTest extends BaseServiceTest{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userService;
	
	@Test
	public void testResultSinIn(){
		UserSignInForm user=new UserSignInForm("zhanglong","123456");
		ResultSinIn resultinIn=userService.resultSinIn(user);
		logger.info("-------------------",resultinIn);
	}
}
