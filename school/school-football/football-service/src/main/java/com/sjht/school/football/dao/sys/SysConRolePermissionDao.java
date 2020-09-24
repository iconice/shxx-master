package com.sjht.school.football.dao.sys;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sjht.school.football.entity.SysConRolePermissionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 ************************************************
 *@ClassName SysConRolePermissionDao
 *@Description 角色资源数据层
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
@Mapper
@Component
public interface SysConRolePermissionDao extends BaseMapper<SysConRolePermissionEntity> {

    /**
     * 根据叫色id删除叫色权限
     * @param roleId
     * @return
     */
    int deleteRolePermissionByRoleId(@Param("roleId")String roleId);

    /**
     * 批量插入角色的权限
     * @param list
     * @return
     */
    int batchAddRolePermission(List<SysConRolePermissionEntity> list);
}
