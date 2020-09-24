package com.sjht.school.football.req.sys;

import com.sjht.school.common.entity.PageBase;

/**
 ************************************************
 *@ClassName QueryRolePageReq
 *@Description 角色分页查询请求
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
public class QueryRolePageReq extends PageBase {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
