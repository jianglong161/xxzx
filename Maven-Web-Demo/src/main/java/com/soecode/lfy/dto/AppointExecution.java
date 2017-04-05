package com.soecode.lfy.dto;

import com.soecode.lfy.entity.Appointment;
import com.soecode.lfy.enums.AppointStateEnum;

/**
 * 用来存储执行预约操作的返回的结果
 * @author Still2Almost
 *
 */
public class AppointExecution {	
	//图书的id
	private long bookId;
	//秒杀预约结果状态
	private int state;
	// 状态标识
	private String stateInfo;
	// 预约成功对象
	private Appointment appointment;
	public AppointExecution(){
		
	}
	// 预约失败的构造器
	public AppointExecution(long bookId,AppointStateEnum appointStateEnum){
		this.bookId=bookId;
		this.state=appointStateEnum.getState();
		this.stateInfo=appointStateEnum.getStateInfo();
		
	}
	//预约成功的构造器
	public AppointExecution(long bookId,
			AppointStateEnum appointStateEnum,
			Appointment appointment){
		this.bookId=bookId;
		this.state=appointStateEnum.getState();
		this.stateInfo=appointStateEnum.getStateInfo();
		this.appointment=appointment;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	
}
