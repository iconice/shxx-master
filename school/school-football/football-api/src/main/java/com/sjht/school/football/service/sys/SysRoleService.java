package com.sjht.school.football.service.sys;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.football.entity.SysRoleEntity;
import com.sjht.school.football.req.sys.AddRoleReq;
import com.sjht.school.football.req.sys.QueryRolePageReq;
import com.sjht.school.football.resp.sys.QueryRolePageResp;

import java.util.List;
import java.util.Set;


/**
 ************************************************
 *@ClassName SysRoleService
 *@Description 角色接口
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
public interface SysRoleService {

    /**
     * 分页查询角色
     * @param queryRolePageReq
     * @return
     */
    PageResult<QueryRolePageResp> querRolePageList(QueryRolePageReq queryRolePageReq);

    /**
     * 添加叫色
     * @param addRoleReq
     * @return
     */
    BaseResponse addRole(AddRoleReq addRoleReq);

    /**
     * 删除叫色
     * @param roleId
     * @return
     */
    BaseResponse deleteRole(String roleId);

    /**
     * 得到角色信息
     * @param id
     * @return
     */
    SysRoleEntity roleInfo(String id);

    /**
     * 提交编辑
     * @param sysRoleEntity
     * @return
     */
    BaseResponse submitEdit(SysRoleEntity sysRoleEntity);

    /**
     * 得到所有角色
     * @return
     */
    List<SysRoleEntity> getAllRoleList();

    /**
     * 得到绑定的叫色id
     * @param userId
     * @return
     */
    Set<String> getRoleIds(String userId);

    /**
     * 提交权限
     * @param userId
     * @param roleId
     * @return
     */
    BaseResponse assignRole(String userId, String roleId);
}
