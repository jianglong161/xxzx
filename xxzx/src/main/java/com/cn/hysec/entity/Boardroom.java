package com.cn.hysec.entity;

public class Boardroom {
	private int id;		
	private String boardroomName;	//会议室名字
	private String boardroomStatue;//会议室状态 0：未使用 1已使用 2已申请 
	private String boardroomPosition;//会议室位置
	private String applyDate;//申请日期
	private String applyTime;//申请时间
	private String applyDuration;//申请时长
	private String applyDepartment;//申请部门
	private String applicant;//申请人
	private int applyAccount;//申请帐号
	private String userPhone;//申请人手机号
	private String userId;//申请人用户id
	private String remarks;//备注
	
	
	@Override
	public String toString(){
		return "Boardroom [id=" + id + ", "
				+ "boardroomName=" + boardroomName + ", "
				+ "boardroomPosition=" + boardroomPosition + ", "
				+ "applyDate=" + applyDate + ", "
				+ "applyTime="+ applyTime + ", "
				+ "applyDuration=" + applyDuration +","
				+ " applyDepartment=" + applyDepartment+ ", "
				+ " applicant=" + applicant+ ", "
				+ " applicant=" + applicant+ ", "
				+ " applyAccount=" + applyAccount+ ", "
				+ " userPhone=" + userPhone+ ", "
				+ " userId=" + userId+ ", "
				+ " remarks=" + remarks+ ", "
				+ "toString()=" + super.toString() + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBoardroomName() {
		return boardroomName;
	}


	public void setBoardroomName(String boardroomName) {
		this.boardroomName = boardroomName;
	}


	public String getBoardroomStatue() {
		return boardroomStatue;
	}


	public void setBoardroomStatue(String boardroomStatue) {
		this.boardroomStatue = boardroomStatue;
	}


	public String getBoardroomPosition() {
		return boardroomPosition;
	}


	public void setBoardroomPosition(String boardroomPosition) {
		this.boardroomPosition = boardroomPosition;
	}


	public String getApplyDate() {
		return applyDate;
	}


	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}


	public String getApplyTime() {
		return applyTime;
	}


	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}


	public String getApplyDuration() {
		return applyDuration;
	}


	public void setApplyDuration(String applyDuration) {
		this.applyDuration = applyDuration;
	}


	public String getApplyDepartment() {
		return applyDepartment;
	}


	public void setApplyDepartment(String applyDepartment) {
		this.applyDepartment = applyDepartment;
	}


	public String getApplicant() {
		return applicant;
	}


	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}


	public int getApplyAccount() {
		return applyAccount;
	}


	public void setApplyAccount(int applyAccount) {
		this.applyAccount = applyAccount;
	}


	public String getUserPhone() {
		return userPhone;
	}


	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
