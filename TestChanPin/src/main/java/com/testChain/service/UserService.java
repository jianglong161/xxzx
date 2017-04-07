package com.testChain.service;

import com.testChain.dto.CheckResult;
import com.testChain.dto.ResultSinIn;
import com.testChain.vo.UserSignInForm;

public interface UserService {
	/**
	 * 登录正确
	 * @param username
	 * @return
	 */
	ResultSinIn resultSinIn(UserSignInForm  userSignInForm);
	/**
	 * 检查邮箱是否存在
	 * @param userEmail
	 * @return
	 */
	CheckResult checkEmail(String userEmail);
	/**
	 * 检查账户名是否存在
	 * @param userName
	 * @return
	 */
	CheckResult checkUserName(String userName);
}
