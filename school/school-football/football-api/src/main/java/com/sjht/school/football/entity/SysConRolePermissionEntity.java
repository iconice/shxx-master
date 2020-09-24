package com.sjht.school.football.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.sjht.school.common.entity.BaseEntity;

/**
 ************************************************
 *@ClassName SysConRolePermissionEntity
 *@Description 角色和资源关联实体类
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
@TableName("sys_con_role_permission")
public class SysConRolePermissionEntity extends BaseEntity {

    private String roleId;

    private String permissionId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}
