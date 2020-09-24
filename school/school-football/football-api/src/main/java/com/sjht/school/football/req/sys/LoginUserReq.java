package com.sjht.school.football.req.sys;

import java.io.Serializable;

/**
 ************************************************
 *@ClassName LoginUserReq
 *@Description 登录请求
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
public class LoginUserReq implements Serializable {

    private String userName;

    private String password;

    private String code;

    public LoginUserReq(String userName, String password, String code) {
        this.userName = userName;
        this.password = password;
        this.code = code;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
