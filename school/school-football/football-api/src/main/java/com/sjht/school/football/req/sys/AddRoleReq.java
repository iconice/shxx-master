package com.sjht.school.football.req.sys;

import java.io.Serializable;

/**
 ************************************************
 *@ClassName AddRoleReq
 *@Description 添加角色亲求类
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
public class AddRoleReq implements Serializable {

    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
