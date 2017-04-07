package com.testChain.service.impl;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.corba.se.impl.io.FVDCodeBaseImpl;
import com.sun.tools.classfile.Annotation.element_value;
import com.testChain.Exception.DataExistException;
import com.testChain.Exception.DataMatchException;
import com.testChain.dao.UserDao;
import com.testChain.dto.CheckResult;
import com.testChain.dto.ResultSinIn;
import com.testChain.entity.User;
import com.testChain.service.UserService;
import com.testChain.vo.UserSignInForm;
@Service
public class UserServiceImp implements UserService{
	public static final String CANNT_USE = "已被使用";
    public static final String CAN_USE = "可以使用";
	@Autowired
	private UserDao userDao;
	public ResultSinIn resultSinIn(UserSignInForm userSignInForm) {
		// 密码加密处理
		User user=userDao.selectByName(userSignInForm.getUserName());
		if (user==null) {
			throw new DataExistException("用户不存在");
		}else if(!user.getUserPass().equals(userSignInForm.getUserPass())){
			throw new DataMatchException("用户名或密码错误");
		}else{
			//用户登录的状态保存在Controller
			return new ResultSinIn(true, userSignInForm.getUserName());
		}
		
	}
	public boolean checkUserIsExistByName(String userName){
		User user=userDao.selectByName(userName);
		if(user!=null){
			return true;
		}else {
			return true;
		}
	}
	public boolean checkUserIsExistByEmail(String userEmail){
		User user=userDao.selectByEmail(userEmail);
		if(user!=null){
			return true;
		}else {
			return true;
		}
	}
	public CheckResult checkEmail(String userEmail) {
		
		
		if (checkUserIsExistByEmail(userEmail)) {
			
			 return new CheckResult(true,CANNT_USE);
		}else {
			return new CheckResult(true, CAN_USE);
		}
		
	}

	public CheckResult checkUserName(String userName) {
		if (checkUserIsExistByEmail(userName)) {
            return new CheckResult(true, CANNT_USE);
        } else {
            return new CheckResult(false,CAN_USE);
        }
		
	}

	

}
