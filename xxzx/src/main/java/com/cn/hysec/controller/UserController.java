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
import com.cn.hysec.service.UserService;

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
    @RequestMapping("login")
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request){
    	
    	Map<String, Object> map = new HashMap<String, Object>();
    	int userId = Integer.parseInt(request.getParameter("id"));
    	
    	String password = request.getParameter("password");
    	
    	User user = this.userService.login(userId, password);
    	
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
}  
