package com.sjht.school.football.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.sjht.school.common.entity.BaseEntity;

/**
 ************************************************
 *@ClassName SysConUserRoleEntity
 *@Description 角色和用户关联实体类
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
@TableName("sys_con_user_role")
public class SysConUserRoleEntity extends BaseEntity {

    private String roleId;

    private String userId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
