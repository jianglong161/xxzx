package com.cn.hysec.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hysec.entity.User;
import com.cn.hysec.md5.MD5Util;
import com.cn.hysec.service.UserService;
import com.sun.security.auth.UnixNumericUserPrincipal;

@Controller  
@RequestMapping("/user")  
public class UserController {  
    @Resource  
    private UserService userService;  
      
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
    	int userId = Integer.parseInt(request.getParameter("id"));
    	
    	String password = request.getParameter("password");
    	//密码加密
    	User user = this.userService.login(userId, MD5Util.MD5(password));
    	
    	if(user != null){
			HttpSession session =  request.getSession();
			session.setAttribute("account", user);
			session.setAttribute("userId", user.getUserId());
			map.put("code", 0);
			map.put("msg", user.getUserId());
		}
		else{
			map.put("code", 1);
			map.put("msg", "用户名密码错误！");
		}
		return map;
    }
    /**
     * 
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
