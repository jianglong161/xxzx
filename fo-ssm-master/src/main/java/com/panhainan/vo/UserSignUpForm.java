package com.panhainan.vo;

/**
 * Created by FirePan on 2017/1/23.
 */
public class UserSignUpForm {
    private String userName;
    private String userPass;
    private String userEmail;

    public UserSignUpForm() {
    }

    public UserSignUpForm(String userName, String userPass, String userEmail) {
        this.userName = userName;
        this.userPass = userPass;
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "UserSignForm{" +
                "userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
