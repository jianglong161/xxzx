package com.soecode.lfy.enums;

import com.sun.corba.se.spi.monitoring.StatisticsAccumulator;

public enum AppointStateEnum {
	SUCCESS(1,"ԤԼ�ɹ�"),
	NO_NUMBER(0, "��治��"),
	REPEAT_APPOINT(-1, "�ظ�ԤԼ"), 
	INNER_ERROR(-2, "ϵͳ�쳣");
	
	private int state;
	private String stateInfo;
	private AppointStateEnum(int state,String stateInfo){
		this.state=state;
		this.stateInfo=stateInfo;
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
	public static AppointStateEnum stateOf(int index){
		for(AppointStateEnum state:values()){
			if(state.getState()==index){
				return state;
			}
		}
		return null;
		
	}
}
