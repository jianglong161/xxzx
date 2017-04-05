package com.soecode.lfy.dto;

import com.soecode.lfy.entity.Appointment;
import com.soecode.lfy.enums.AppointStateEnum;

/**
 * �����洢ִ��ԤԼ�����ķ��صĽ��
 * @author Still2Almost
 *
 */
public class AppointExecution {	
	//ͼ���id
	private long bookId;
	//��ɱԤԼ���״̬
	private int state;
	// ״̬��ʶ
	private String stateInfo;
	// ԤԼ�ɹ�����
	private Appointment appointment;
	public AppointExecution(){
		
	}
	// ԤԼʧ�ܵĹ�����
	public AppointExecution(long bookId,AppointStateEnum appointStateEnum){
		this.bookId=bookId;
		this.state=appointStateEnum.getState();
		this.stateInfo=appointStateEnum.getStateInfo();
		
	}
	//ԤԼ�ɹ��Ĺ�����
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
