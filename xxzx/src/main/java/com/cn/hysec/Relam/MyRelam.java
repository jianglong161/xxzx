package com.cn.hysec.Relam;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cn.hysec.dao.UserMapper;
import com.cn.hysec.entity.User;
import com.cn.hysec.service.UserService;

public class MyRelam extends AuthorizingRealm{
	@Resource
	private UserService userService;
	@Resource
	private UserMapper userDao;
	
	private  final Logger logger = LoggerFactory.getLogger(this.getClass());  
	/**
	 * 用于权限的验证
	 * @param PrincipalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userName=principals.getPrimaryPrincipal().toString();
		SimpleAuthorizationInfo simpleAuthorizationInfo=
				new SimpleAuthorizationInfo();
		Set<String> role=(Set<String>) userService.findRoles(userName);
		Set<String> permissions=(Set<String>) userService.findPermissions(userName);
		simpleAuthorizationInfo.setRoles(role);
		simpleAuthorizationInfo.setStringPermissions(permissions);
		return simpleAuthorizationInfo;
		
	}
	/**
	 * 首先执行这个登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken=(UsernamePasswordToken) token;
		//String username=token.getPrincipal().toString();
		String username=upToken.getUsername().trim();
		String userNamestring=String.valueOf(username);
		logger.debug(userNamestring);
		//User user=userService.findRoles(username);
		logger.trace("sssss:",userService);
		User user=null;
	//	User user2=userDao.findUserByUserName(userNamestring);
		
		if(userNamestring instanceof String){
			 user = userService.findUserByUserName(userNamestring);
		}
		
		//logger.debug(user.getUserName());
		
		//System.out.println(user.toString());
		
		
		if(user!=null){
			 //将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数传入realName。
			  AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),
	                      "a") ;
			return authenticationInfo;
		}else {
			return null;
		}
		
	
		
	}

}
