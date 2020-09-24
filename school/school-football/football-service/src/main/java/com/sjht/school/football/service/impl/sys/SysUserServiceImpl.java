package com.sjht.school.football.service.impl.sys;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sjht.school.common.constant.CoreConst;
import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.common.entity.ResultUtil;
import com.sjht.school.common.utils.IdUtil;
import com.sjht.school.football.dao.sys.SysUserDao;
import com.sjht.school.football.entity.SysUserEntity;
import com.sjht.school.football.entity.football.student.GradeUserEntity;
import com.sjht.school.football.req.football.student.EditUserReq;
import com.sjht.school.football.req.sys.AddUserReq;
import com.sjht.school.football.req.sys.QueryUserPageReq;
import com.sjht.school.football.req.sys.LoginUserReq;
import com.sjht.school.football.req.sys.UpdateUserReq;
import com.sjht.school.football.resp.sys.QueryUserPageResp;
import com.sjht.school.football.resp.sys.TeacherListResp;
import com.sjht.school.football.service.football.student.GradeUserService;
import com.sjht.school.football.service.sys.SysUserService;
import com.xiaoleilu.hutool.crypto.SecureUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements IService<SysUserEntity>, SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private GradeUserService classUserService;

    @Override
    public BaseResponse loginUser(LoginUserReq loginUserReq) {
        BaseResponse baseResponse = new BaseResponse();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken upToken = new UsernamePasswordToken(loginUserReq.getUserName(), SecureUtil.md5(loginUserReq.getPassword()));
        subject.login(upToken);
        SysUserEntity sysUserEntity = (SysUserEntity) subject.getPrincipal();
        return baseResponse.Ok();
    }

    @Override
    public PageResult queryUserPage(QueryUserPageReq queryUserPageReq) {
        Map<String, Object> params = new HashMap<>();
        PageResult pageResult = new PageResult();
        Integer pageNo = Integer.valueOf(queryUserPageReq.getOffset());
        Integer pageSize = Integer.valueOf(queryUserPageReq.getLimit());
        Page<QueryUserPageResp> page = new Page<>(pageNo, pageSize);

        List<QueryUserPageResp> datas = new ArrayList<>();
        if (StringUtils.isNotBlank(queryUserPageReq.getEmail())) {
            params.put("email", queryUserPageReq.getEmail());
        }
        if (StringUtils.isNotBlank(queryUserPageReq.getPhone())) {
            params.put("tell", queryUserPageReq.getPhone());
        }
        if (StringUtils.isNotBlank(queryUserPageReq.getUsername())) {
            params.put("userName", queryUserPageReq.getUsername());
        }

        Long count = sysUserDao.queryUserPageCont(params);
        if (count > 0) {
            datas = sysUserDao.queryUserPageList(page, params);
        }
        return pageResult.resultPage(datas, count);
    }

    @Override
    public List<String> getUserIds(String roleId) {
        return sysUserDao.getUserIds(roleId);
    }

    @Transactional
    @Override
    public BaseResponse deleteUserById(String userId) {
        // 删除用户
        Boolean b = this.deleteById(userId);
        // 删除用户得数据权限
        classUserService.batchDelete(userId);
        return b ? ResultUtil.OK("删除成功") : ResultUtil.error("删除失败");
    }

    @Transactional
    @Override
    public BaseResponse addUser(AddUserReq addUserReq) {
        String userId = IdUtil.getId();
        Wrapper<SysUserEntity> wrapper = new EntityWrapper<>();
        wrapper.where("user_name={0}", addUserReq.getName());
        List<SysUserEntity> list = this.selectList(wrapper);
        // 判断该用户名是否已经添加
        if (list.size() == 0) {
            String[] gradeIds = addUserReq.getGradeIds().split(",");
            List<GradeUserEntity> userEntities = new ArrayList<>();
            for (String gradeId : gradeIds) {
                GradeUserEntity userEntity = new GradeUserEntity();
                userEntity.setId(IdUtil.getId());
                userEntity.setGradeId(gradeId);
                userEntity.setUserId(userId);
                userEntities.add(userEntity);
            }
            classUserService.batchInsert(userEntities);
            SysUserEntity entity = new SysUserEntity();
            entity.setId(userId);
            entity.setUserName(addUserReq.getUserName());
            entity.setPassword(SecureUtil.md5(CoreConst.DEFAULT_PASSWORD));
            entity.setName(addUserReq.getName());
            entity.setEmail(addUserReq.getEmail());
            entity.setTell(addUserReq.getTell());
            entity.setUserType(addUserReq.getUserType());
            entity.setStatus("1");
            this.insert(entity);
            return ResultUtil.OK("添加成功");
        }
        return ResultUtil.error("用户名已经存在");
    }

    @Override
    public List<TeacherListResp> getTeacherList() {
        return sysUserDao.getTeacherList();
    }

    @Override
    public SysUserEntity getUserInfo(String userId) {
        return this.selectById(userId);
    }

    @Transactional
    @Override
    public BaseResponse submitEditUser(EditUserReq userEntity) {
        if (2 == userEntity.getType()) {
            String[] gradeIds = userEntity.getGradeIds().split(",");
            // 先删除以前的
            classUserService.batchDelete(userEntity.getId());
            // 再添加
            List<GradeUserEntity> userEntities = new ArrayList<>();
            for (String gradeId : gradeIds) {
                GradeUserEntity entity = new GradeUserEntity();
                entity.setId(IdUtil.getId());
                entity.setUserId(userEntity.getId());
                entity.setGradeId(gradeId);
                userEntities.add(entity);
            }
            classUserService.batchInsert(userEntities);
        }
        sysUserDao.updateUserById(userEntity);
        return ResultUtil.OK("编辑成功");
    }

    @Override
    public BaseResponse updatePassWordById(UpdateUserReq updateUserReq) {
        sysUserDao.updatePasswordById(updateUserReq);
        return ResultUtil.OK("密码更改成功");
    }
}
