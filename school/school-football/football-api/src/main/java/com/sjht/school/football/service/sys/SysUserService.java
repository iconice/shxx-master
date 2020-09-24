package com.sjht.school.football.service.sys;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.football.entity.SysUserEntity;
import com.sjht.school.football.req.football.student.EditUserReq;
import com.sjht.school.football.req.sys.AddUserReq;
import com.sjht.school.football.req.sys.QueryUserPageReq;
import com.sjht.school.football.req.sys.LoginUserReq;
import com.sjht.school.football.req.sys.UpdateUserReq;
import com.sjht.school.football.resp.sys.TeacherListResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 ************************************************
 *@ClassName SysUserService
 *@Description 用户接口
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
public interface SysUserService {

    /**
     * 登录
     * @param loginUserReq
     * @return
     */
    BaseResponse loginUser(LoginUserReq loginUserReq);

    /**
     * 分页查询用户列表
     * @param queryUserPageReq
     * @return
     */
    PageResult queryUserPage(QueryUserPageReq queryUserPageReq);

    /**
     * 根据角色id查询用户id
     * @param roleId
     * @return
     */
    List<String> getUserIds(String roleId);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    BaseResponse deleteUserById(String userId);

    /**
     * 新增用户
     * @param addUserReq
     * @return
     */
    BaseResponse addUser(AddUserReq addUserReq);

    /**
     * 得到老师列表
     * @return
     */
    List<TeacherListResp> getTeacherList();

    /**
     * 得到用户信息
     * @param userId
     * @return
     */
    SysUserEntity getUserInfo(String userId);

    /**
     * 提交用户编辑
     * @param userEntity
     * @return
     */
    BaseResponse submitEditUser(EditUserReq userEntity);


    /**
     * 更改密码
     * @param updateUserReq
     * @return
     * SecureUtil.md5(CoreConst.DEFAULT_PASSWORD)
     */
    BaseResponse updatePassWordById(UpdateUserReq updateUserReq);
}
