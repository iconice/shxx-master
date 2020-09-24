package com.sjht.school.football.dao.sys;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sjht.school.football.entity.SysUserEntity;
import com.sjht.school.football.req.football.student.EditUserReq;
import com.sjht.school.football.req.sys.UpdateUserReq;
import com.sjht.school.football.resp.sys.QueryUserPageResp;
import com.sjht.school.football.resp.sys.TeacherListResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 ************************************************
 *@ClassName SysUserDao
 *@Description 用户数据层
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
@Component
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {

    /**
     * 用户登录
     * @param userName
     * @return
     */
    SysUserEntity userLogin(@Param("userName") String userName);

    /**
     * 分页查询得到列表
     * @param page
     * @param params
     * @return
     */
    List<QueryUserPageResp> queryUserPageList(Page<QueryUserPageResp> page, @Param("params") Map<String, Object> params);

    /**
     * 分页查询数量
     * @param params
     * @return
     */
    Long queryUserPageCont(@Param("params") Map<String, Object> params);

    /**
     * 根据角色id查询用户ids
     * @param roleId
     * @return
     */
    List<String> getUserIds(@Param("roleId")String roleId);

    /**
     * 得到老师列表
     * @return
     */
    List<TeacherListResp> getTeacherList();

    /**
     * 更新用户
     * @param userEntity
     * @return
     */
    int updateUserById(@Param("ew") EditUserReq userEntity);

    /**
     * 更改用户密码
     * @param userEntity
     * @return
     */
    int updatePasswordById(@Param("user") UpdateUserReq updateUserReq);
}
