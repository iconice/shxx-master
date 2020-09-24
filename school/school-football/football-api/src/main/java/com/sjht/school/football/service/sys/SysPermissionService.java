package com.sjht.school.football.service.sys;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.football.entity.PermissionEntity;
import com.sjht.school.football.req.sys.AddPermissionReq;
import com.sjht.school.football.resp.sys.GetAllMenuResp;
import com.sjht.school.football.resp.sys.QueryPermissionListResp;

import java.util.List;

/**
 ************************************************
 *@ClassName SysPermissionService
 *@Description 资源接口
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
public interface SysPermissionService {

    /**
     * 得到菜单
     * @param userId
     * @return
     */
    BaseResponse getMenuListByUserId(String userId);

    /**
     * 得到资源列表
     * @param flage
     * @return
     */
    List<QueryPermissionListResp> queryPermissionList(String flage);

    /**
     * 得到所有菜单
     * @return
     */
    List<GetAllMenuResp> getAllMenu();

    /**
     * 添加权限
     * @param addPermissionReq
     * @return
     */
    BaseResponse AddPermission(AddPermissionReq addPermissionReq);

    /**
     * 删除菜单
     * @param id
     * @return
     */
    BaseResponse deletPermission(String id);

    /**
     * 得到资源详情
     * @param id
     * @return
     */
    PermissionEntity getPermissionInfo(String id);

    /**
     * 编辑资源
     * @param permissionEntity
     * @return
     */
    BaseResponse editPermission(PermissionEntity permissionEntity);

    /**
     * 根据角色id查询资源
     * @param roleId
     * @return
     */
    List<PermissionEntity> findByRoleId(String roleId);

    /**
     * 为角色分配权限
     * @param roleId
     * @param permissionIdList
     * @return
     */
    BaseResponse assignPermissionByRole(String roleId, List<String> permissionIdList);
}
