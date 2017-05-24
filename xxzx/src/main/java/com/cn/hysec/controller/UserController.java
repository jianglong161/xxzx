package com.cn.hysec.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ConcurrentAccessException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hysec.entity.User;
import com.cn.hysec.md5.MD5Util;
import com.cn.hysec.service.UserService;
import com.sun.security.auth.UnixNumericUserPrincipal;

import sun.util.logging.resources.logging;

@Controller  
@RequestMapping("/user")  
public class UserController {  
    @Resource  
    private UserService userService;  
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping("showUser")  
    public String toIndex(HttpServletRequest request,Model model){  
        int userId = Integer.parseInt(request.getParameter("id"));  
        User user = this.userService.getUserById(userId);  
        System.out.print(user.getUserName());
        model.addAttribute("user", user);  
        return "mobile/main";  
    }
    /**
     * 登录功能
     * @param request
     * @return
     */

    @RequestMapping("login")
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request){
    	Map<String, Object> map = new HashMap<String, Object>();
    	String account=request.getParameter("id");
    	String password = request.getParameter("password");
    	//密码加密username
    	User user=userService.findPassByAccount(account);
    	int userId=user.getUserId();
    	Subject subject=SecurityUtils.getSubject();
    	UsernamePasswordToken token=
    			new UsernamePasswordToken(account,password);
    	try{
    		subject.login(token);
    		if(subject.isAuthenticated()){
    			//User user = userService.login(userId, password);
    			HttpSession session =  request.getSession();
    			session.setAttribute("account", user);
    			session.setAttribute("userId", user.getUserId());
    			map.put("code", 0);
    			map.put("msg", user.getUserId());
    			
    		}
    	}catch (UnknownAccountException   e) {
    		map.put("code", 1);
			map.put("msg", "用户找不到");
		}catch (LockedAccountException   e) {
			map.put("code", 1);
			map.put("msg", "帐号锁定！");
		}catch (ConcurrentAccessException e) {
			map.put("code", 1);
			map.put("msg", "多次登录！");
		}catch (AuthenticationException e) {
			map.put("code", 1);
			map.put("msg", "用户名密码错误");
		}
    	return map;
    }
//    	return map;
//    	if(user != null){
//			HttpSession session =  request.getSession();
//			session.setAttribute("account", user);
//			session.setAttribute("userId", user.getUserId());
//			map.put("code", 0);
//			map.put("msg", user.getUserId());
//		}
//		else{
//			map.put("code", 1);
//			map.put("msg", "用户名密码错误！");
//		}
	@RequestMapping	("/admin")
	public String admin(){
		return "admin";
		
    }
	@RequestMapping("/user")
	public String user(){
		return "user";
	}
	
    
    /**
     * 注册
     */
    @RequestMapping("logup")
    @ResponseBody
    public Map<String, Object> logup(HttpServletRequest request){
    	Map<String, Object> map = new HashMap<String, Object>();
    	int userId = Integer.parseInt(request.getParameter("id"));
    	String userName=request.getParameter("userName");
    	String password=request.getParameter("password");
    	String mDpassword=MD5Util.MD5(password);
    	Integer phoneNumber=Integer.parseInt(request.getParameter("phoneNumber"));
    	String idCord=request.getParameter("idCord");
    	
    	//判断是否用户存在
    	User user= this.userService.login(userId,mDpassword);
    	if(user==null){
    		try{
    			user.setIdCord(idCord);
        		user.setPassword(mDpassword);
        		user.setPhoneNumber(phoneNumber);
        		user.setUserName(userName);
        		user.setUserId(userId);
        		int result =userService.insert(user);
        		HttpSession session =  request.getSession();
    			session.setAttribute("account", user);
    			session.setAttribute("userId", user.getUserId());
    			map.put("code", 0);
    			map.put("msg", user.getUserId());
    		}catch (Exception e) {
				// TODO: handle exception
    			e.printStackTrace();
			}
    		
    	}else {
    		map.put("code", 1);
			map.put("msg", "用户已经存在！");
		}
		return map;
    	
    }
}  
