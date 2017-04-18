package com.cn.hysec.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hysec.entity.OfficeSupplies;
import com.cn.hysec.entity.Orders;
import com.cn.hysec.entity.User;
import com.cn.hysec.service.OfficeSuppliesService;
import com.cn.hysec.service.orderServies;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("officeSupplies")
public class OfficeSuppliesController {
	@Resource
	private OfficeSuppliesService officeSuppliesService;
	@Resource
	private orderServies orderService;
	@RequestMapping("list")
	@ResponseBody
	public Map<String,Object>  officeSuppliesList(HttpServletRequest request){
		Map<String,Object> map=new HashMap<String,Object>();
		List<OfficeSupplies> list = (List<OfficeSupplies>)officeSuppliesService.selectAll();
		ArrayList<String[]> alist = new ArrayList<String[]>();
		OfficeSupplies res;
		for(int i=0;i<list.size();i++){
			res = (OfficeSupplies)list.get(i);
			System.out.println(res.getResId().toString()+","+res.getResName());
			String[] array = {res.getResId().toString(),res.getResName()};
			alist.add(array);
		}
		map.put("code", 0);
		map.put("data", alist);
		return map;
	}
	@RequestMapping("officelist")
	public String officeList(HttpServletRequest request,Model model){
		List<OfficeSupplies> list = (List<OfficeSupplies>)officeSuppliesService.selectAll();
		ArrayList<String[]> alist = new ArrayList<String[]>();
		JSONObject js = JSONObject.fromObject(request.getParameter("map"));
		OfficeSupplies res;
		for(int i=0;i<list.size();i++){
			res = (OfficeSupplies)list.get(i);
			if(js.get(res.getResId().toString())!=null){
				String[] array ={res.getResId().toString(),res.getResName(),(String) js.get(res.getResId().toString())};
				alist.add(array);
			}
		}
		System.out.print(alist.get(0)[0]+alist.get(0)[1]+alist.get(0)[2]);
		model.addAttribute("map", alist);
		return "mobile/officelist";
	}
	@RequestMapping("officetj")
	@ResponseBody
	public Map<String,Object> tjorder(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("account");
		int userId = user.getUserId();
		Map<String,Object> map=new HashMap<String,Object>();
		JSONObject ma = JSONObject.fromObject(request.getParameter("map"));
		Iterator it = ma.keys();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = df.format(new Date());
		System.out.print(nowDate);
		List<Orders> list = new ArrayList<Orders>();
		while (it.hasNext()) {  
            Orders order = new Orders();
            String key = (String) it.next();  
            String value = ma.getString(key);  
            System.out.println(key+"-------"+value);
            int resid =Integer.parseInt(key);
            int orderquantity = Integer.parseInt(value);
            System.out.println(resid+"+++++++"+orderquantity);
            order.setResId(resid);
            order.setOrderQuantity(orderquantity);
            order.setUserId(userId);
            order.setOederDate(nowDate);
            order.setOrderBatch("0");
            list.add(order); 
        } 
		System.out.print(list);
		int i = 0;
		try {
			i = orderService.insertOrders(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i> 0){
			map.put("code", 0);
		}else{
			map.put("code", -1);
		}
		return map;
	} 
}
