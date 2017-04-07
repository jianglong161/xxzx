package com.testChain.dto;

public class ResultSinIn {
	private boolean isSuccess;
	private String userName;
	public ResultSinIn(){}
	public ResultSinIn(boolean isSuccess,String userName){
		this.isSuccess=isSuccess;
		this.userName=userName;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString(){
		return "ResultSinIn{" +
            "isSuccess=" + isSuccess +
            ", userName='" + userName + '\'' +
            '}';
	}
}
