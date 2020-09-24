package com.sjht.school.football.resp.sys;

import java.io.Serializable;

/**
 ************************************************
 *@ClassName GetAllMenuResp
 *@Description 添加菜单时目录菜单返回类
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
public class GetAllMenuResp implements Serializable {

    private String id;

    private String name;

    private String parentId;

    private Integer type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
