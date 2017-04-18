package com.cn.hysec.entity;

public class User {
    @Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", idCord=" + idCord + ", toString()=" + super.toString() + "]";
	}

	private Integer userId;

    private String userName;

    private String password;

    private Integer phoneNumber;

    private String idCord;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCord() {
        return idCord;
    }

    public void setIdCord(String idCord) {
        this.idCord = idCord == null ? null : idCord.trim();
    }
}