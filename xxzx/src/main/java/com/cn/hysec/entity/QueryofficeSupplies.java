package com.cn.hysec.entity;

import java.util.Date;

/**
 * 办公用品登记查询
 * @author Still2Almost
 *
 */
public class QueryofficeSupplies {
	private Integer orderQuantity;
	private String resName;
	private String oederDate;
	public String toString(){
		return "QueryofficeSupplies [orderQuantity=" + orderQuantity + 
				", resName=" + resName + 
				", oederDate=" + oederDate + 
				", toString()="
				+ super.toString() + "]";
	}
	public Integer getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public String getOederDate() {
		return oederDate;
	}
	public void setOederDate(String oederDate) {
		this.oederDate = oederDate;
	}
	 
}
