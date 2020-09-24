package com.sjht.school.football.dao.sys;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sjht.school.football.entity.SysRoleEntity;
import com.sjht.school.football.resp.sys.QueryRolePageResp;
import com.sjht.school.football.resp.sys.QueryUserPageResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 ************************************************
 *@ClassName SysRoleDao
 *@Description 角色数据层
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
@Component
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {

    /**
     * 得到所有的校色id
     * @param userId
     * @return
     */
    public Set<String> getRoleIds(@Param("userId")String userId);

    /**
     * 角色分页查询列表
     * @return
     */
    List<QueryRolePageResp> querRolePageList(Page<QueryRolePageResp> page, @Param("params") Map<String, Object> params);

    /**
     * 角色分页查询数量
     * @return
     */
    long querRolePageCount(@Param("params") Map<String, Object> params);

}
