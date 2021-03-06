package com.cn.hysec.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hysec.entity.Menu;
import com.cn.hysec.entity.MenuPermissions;
import com.cn.hysec.entity.User;
import com.cn.hysec.entity.UserRole;
import com.cn.hysec.entity.Role;
import com.cn.hysec.service.MenuPermissionService;
import com.cn.hysec.service.MenuService;
import com.cn.hysec.service.UserService;

@Controller
@RequestMapping("menu")
public class MenuController {
	@Resource
	private MenuService menuService;
	@Resource
	private MenuPermissionService permissionService;
	@Resource
	private UserService userService;
	@RequestMapping("showMenu")
	public String getMenu(HttpServletRequest request,Model model){
		//int userId = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("account");
		int userId=user.getUserId();
		String account=user.getAccount();
		Role roleName=userService.findRoles(account);
		int roleid=roleName.getRoleId();
		UserRole userRole=userService.findUserRoleId(roleid);
		/**
		 * 判断用户权限
		 */
		if(userRole.getId()==1){
			List<Menu> menuList = menuService.selectMenuByUserIdAdmin(userId);
			model.addAttribute("menu", menuList);
		}
		if(userRole.getId()==2){
			List<Menu> menuList = menuService.selectMenuByUserIdUser(userId);
			model.addAttribute("menu", menuList);
		}
		return "mobile/main";
	}
	
	@RequestMapping("pagechange")
	public String pageJump(HttpServletRequest request,Model model){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("account");
		String account=user.getAccount();
		int userId = user.getUserId();
		System.out.println("--------------userid:"+userId);
		int menuId = Integer.parseInt(request.getParameter("id"));
		System.out.println("--------------menuid:"+menuId);
		Menu menu;
		String url;
		MenuPermissions permissions = permissionService.getPermissionByUserId(userId, userId);
		Role roleName=userService.findRoles(account);
		int roleid=roleName.getRoleId();
		UserRole userRole=userService.findUserRoleId(roleid);
		
		if(permissions != null){
			menu = menuService.selectById(menuId);
			url = menu.getMenuLink();
			return "mobile/"+url;
		}else{
			return "mobile/noPremissions";
		}
		
		
	}
	@RequestMapping("/admin")
	public String admin(){
		return "admin";
	}
	@RequestMapping("/user")
	public String user(){
		return "user";
	}
	
}
