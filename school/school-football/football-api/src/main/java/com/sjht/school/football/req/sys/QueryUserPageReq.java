package com.sjht.school.football.req.sys;

import com.sjht.school.common.entity.PageBase;

import java.io.Serializable;

/**
 ************************************************
 *@ClassName QueryUserPageReq
 *@Description 用户分页查询请求类
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
public class QueryUserPageReq extends PageBase {

    private String username;

    private String email;

    private String phone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
