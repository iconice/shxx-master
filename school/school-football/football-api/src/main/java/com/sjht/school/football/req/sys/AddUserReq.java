package com.sjht.school.football.req.sys;

import java.io.Serializable;

/**
 ************************************************
 *@ClassName AddUserReq
 *@Description 添加用户请求
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
public class AddUserReq implements Serializable {

    private String userName;

    private String name;

    private String userType;

    private String email;

    private String tell;

    private String gradeIds;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getGradeIds() {
        return gradeIds;
    }

    public void setGradeIds(String gradeIds) {
        this.gradeIds = gradeIds;
    }
}
