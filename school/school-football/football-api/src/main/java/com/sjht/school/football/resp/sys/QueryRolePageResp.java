package com.sjht.school.football.resp.sys;

import java.io.Serializable;
import java.util.Date;

/**
 ************************************************
 *@ClassName QueryRolePageResp
 *@Description 角色分页响应类
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
public class QueryRolePageResp implements Serializable {

    private String roleId;

    private String name;

    private String description;

    private Date createTime;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
