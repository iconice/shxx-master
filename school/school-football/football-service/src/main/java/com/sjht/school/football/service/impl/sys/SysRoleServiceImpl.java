package com.sjht.school.football.service.impl.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.common.entity.ResultUtil;
import com.sjht.school.common.utils.IdUtil;
import com.sjht.school.common.utils.PageUtil;
import com.sjht.school.football.dao.sys.SysConUserRoleDao;
import com.sjht.school.football.dao.sys.SysRoleDao;
import com.sjht.school.football.entity.SysConUserRoleEntity;
import com.sjht.school.football.entity.SysRoleEntity;
import com.sjht.school.football.req.sys.AddRoleReq;
import com.sjht.school.football.req.sys.QueryRolePageReq;
import com.sjht.school.football.resp.sys.QueryRolePageResp;
import com.sjht.school.football.resp.sys.QueryUserPageResp;
import com.sjht.school.football.service.sys.SysRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRoleEntity> implements IService<SysRoleEntity>, SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Autowired
    private SysConUserRoleDao sysConUserRoleDao;

    @Override
    public PageResult<QueryRolePageResp> querRolePageList(QueryRolePageReq queryRolePageReq) {
        Map<String, Object> params = new HashMap<>();
        PageResult<QueryRolePageResp> pageResult = new PageResult<>();
        Integer pageNo = Integer.valueOf(PageUtil.getPageNo(queryRolePageReq.getLimit(), queryRolePageReq.getOffset()));
        Integer pageSize = Integer.valueOf(queryRolePageReq.getLimit());
        Page<QueryRolePageResp> page = new Page<>(pageNo, pageSize);
        if (StringUtils.isNotBlank(queryRolePageReq.getName())) {
            params.put("name", queryRolePageReq.getName());
        }
        Long count = sysRoleDao.querRolePageCount(params);
        List<QueryRolePageResp> datas = new ArrayList<>();
        if (count > 0) {
            datas = sysRoleDao.querRolePageList(page, params);
        }
        return pageResult.resultPage(datas, count);
    }

    @Override
    public BaseResponse addRole(AddRoleReq addRoleReq) {
        SysRoleEntity roleEntity = new SysRoleEntity();
        roleEntity.setId(IdUtil.getId());
        roleEntity.setName(addRoleReq.getName());
        roleEntity.setDescription(addRoleReq.getDescription());
        roleEntity.setStatus(1);
        this.insert(roleEntity);
        return ResultUtil.OK("添加成功");
    }

    @Transactional
    @Override
    public BaseResponse deleteRole(String roleId) {
        // 删除角色
        this.deleteById(roleId);
        // 删除和用户之间的关联
        Wrapper<SysConUserRoleEntity> wrapper = new EntityWrapper<>();
        wrapper.where("role_id={0}", roleId);
        sysConUserRoleDao.delete(wrapper);
        return ResultUtil.OK("删除成功");
    }

    @Override
    public SysRoleEntity roleInfo(String id) {
        return this.selectById(id);
    }

    @Override
    public BaseResponse submitEdit(SysRoleEntity sysRoleEntity) {
        Boolean b = this.updateById(sysRoleEntity);
        return b ? ResultUtil.OK("编辑成功"): ResultUtil.error("编辑失败");
    }

    @Override
    public List<SysRoleEntity> getAllRoleList() {
        return this.selectList(null);
    }

    @Override
    public Set<String> getRoleIds(String userId) {
        return sysRoleDao.getRoleIds(userId);
    }

    @Transactional
    @Override
    public BaseResponse assignRole(String userId, String roleId) {
        SysConUserRoleEntity entity = new SysConUserRoleEntity();
        Wrapper<SysConUserRoleEntity> wrapper = new EntityWrapper<>();
        wrapper.where("user_id ={0}", userId);
        sysConUserRoleDao.delete(wrapper);
        entity.setId(IdUtil.getId());
        entity.setUserId(userId);
        entity.setRoleId(roleId);
        sysConUserRoleDao.insert(entity);
        return ResultUtil.OK("授权成功");
    }
}
