package com.sjht.school.football.dao.sys;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.sjht.school.football.entity.PermissionEntity;
import com.sjht.school.football.entity.SysConRolePermissionEntity;
import com.sjht.school.football.resp.sys.GetAllMenuResp;
import com.sjht.school.football.resp.sys.QueryPermissionListResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 ************************************************
 *@ClassName SysPermissionDao
 *@Description 资源数据层
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
@Component
@Mapper
public interface SysPermissionDao extends BaseMapper<PermissionEntity> {

    /**
     * 查询用户的菜单
     * @param userId
     * @return
     */
    List<PermissionEntity> getMenuListByUserId(@Param("userId")String userId);

    /**
     * 查询用户的权限
     * @param userId
     * @return
     */
    Set<String> getPermissions(@Param("userId")String userId);

    /**
     * 查询资源列表不分页
     * @param status
     * @return
     */
    List<QueryPermissionListResp> queryPermissionList(@Param("status") String status);

    /**
     * 得到所有菜单
     * @return
     */
    List<GetAllMenuResp> getAllMenu();

    /**
     * 更新资源
     * @param permissionEntity
     * @return
     */
    int updatePermission(@Param("ew") PermissionEntity permissionEntity);

    /**
     * 根据角色id查询权限
     * @param roleId
     * @return
     */
    List<PermissionEntity> findByRoleId(@Param("roleId")String roleId);
}
