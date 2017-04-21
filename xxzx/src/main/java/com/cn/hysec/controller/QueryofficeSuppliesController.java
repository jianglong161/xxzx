package com.cn.hysec.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hysec.entity.QueryofficeSupplies;
import com.cn.hysec.entity.User;
import com.cn.hysec.service.QueryofficeSuppliesService;

@Controller()
@RequestMapping("QueryofficeSupplies")
public class QueryofficeSuppliesController {
	@Resource
	private QueryofficeSuppliesService queryofficeSuppliesService;
	@RequestMapping("query")
	@ResponseBody
	public Map<String, Object>officeSuppliesList(HttpServletRequest request){
		Map<String, Object> map=new HashMap<String, Object>();
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("account"); 
		int userId=user.getUserId();
		List<QueryofficeSupplies> list=
				queryofficeSuppliesService.queryofficeSupplies(userId);
		List<String[]> aList=new ArrayList<String[]>();
		QueryofficeSupplies queryofficeSupplies;
		for(int i=0;i<list.size();i++){
			queryofficeSupplies=list.get(i);
			System.out.println(queryofficeSupplies.getOederDate().toString()
					+","+queryofficeSupplies.getResName().toString()+","
					+queryofficeSupplies.getOrderQuantity().toString());
			String[] array={queryofficeSupplies.getOederDate()
					,queryofficeSupplies.getResName()
					,queryofficeSupplies.getOrderQuantity().toString()};
			aList.add(array);
			
		}
		map.put("code", 0);
		map.put("data", aList);
		return map;
	}
}
