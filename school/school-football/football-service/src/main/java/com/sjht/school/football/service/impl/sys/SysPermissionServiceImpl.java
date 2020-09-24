package com.sjht.school.football.service.impl.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.ObjectResponse;
import com.sjht.school.common.entity.ResultUtil;
import com.sjht.school.common.utils.IdUtil;
import com.sjht.school.football.dao.sys.SysConRolePermissionDao;
import com.sjht.school.football.dao.sys.SysPermissionDao;
import com.sjht.school.football.entity.PermissionEntity;
import com.sjht.school.football.entity.SysConRolePermissionEntity;
import com.sjht.school.football.req.sys.AddPermissionReq;
import com.sjht.school.football.resp.sys.GetAllMenuResp;
import com.sjht.school.football.resp.sys.QueryPermissionListResp;
import com.sjht.school.football.service.sys.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionDao, PermissionEntity> implements IService<PermissionEntity>, SysPermissionService {

    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Autowired
    private SysConRolePermissionDao sysConRolePermissionDao;

    @Override
    public BaseResponse getMenuListByUserId(String userId) {
        BaseResponse baseResponse = new ObjectResponse<>();
        List<PermissionEntity> menuList = sysPermissionDao.getMenuListByUserId(userId);
        return ((ObjectResponse) baseResponse).OK(menuList);
    }

    @Override
    public List<QueryPermissionListResp> queryPermissionList(String flage) {
        return sysPermissionDao.queryPermissionList(flage);
    }

    @Override
    public List<GetAllMenuResp> getAllMenu() {
        return sysPermissionDao.getAllMenu();
    }

    @Override
    public BaseResponse AddPermission(AddPermissionReq addPermissionReq) {
        PermissionEntity permissionEntity = new PermissionEntity();
        permissionEntity.setId(IdUtil.getId());
        permissionEntity.setName(addPermissionReq.getName());
        permissionEntity.setIcon(addPermissionReq.getIcon());
        permissionEntity.setDescription(addPermissionReq.getDescription());
        permissionEntity.setOrderNum(addPermissionReq.getOrderNum());
        permissionEntity.setParentId(addPermissionReq.getParentId());
        permissionEntity.setPerms(addPermissionReq.getPerms());
        permissionEntity.setStatus(1);
        permissionEntity.setType(addPermissionReq.getType());
        permissionEntity.setUrl(addPermissionReq.getUrl());
        this.insert(permissionEntity);
        return ResultUtil.OK("新增成功");
    }

    @Transactional
    @Override
    public BaseResponse deletPermission(String id) {
        // 删除资源
        this.deleteById(id);
        // 删除和角色的绑定资源
        Wrapper<SysConRolePermissionEntity> wrapper = new EntityWrapper<>();
        wrapper.where("permission_id={0}", id);
        sysConRolePermissionDao.delete(wrapper);
        return ResultUtil.OK("删除成功");
    }

    @Override
    public PermissionEntity getPermissionInfo(String id) {
        return this.selectById(id);
    }

    @Override
    public BaseResponse editPermission(PermissionEntity permissionEntity) {
        int n = sysPermissionDao.updatePermission(permissionEntity);
        return n > 0 ? ResultUtil.OK("编辑成功") : ResultUtil.error("编辑失败");
    }

    @Override
    public List<PermissionEntity> findByRoleId(String roleId) {
        return sysPermissionDao.findByRoleId(roleId);
    }

    @Override
    @Transactional
    public BaseResponse assignPermissionByRole(String roleId, List<String> permissionIdList) {
        int addCount = 0;
        // 删除以前的权限
        int deleteCount = sysConRolePermissionDao.deleteRolePermissionByRoleId(roleId);
        // 添加权限
        List<SysConRolePermissionEntity> list = new ArrayList<>();
        for (String permissionId : permissionIdList) {
            SysConRolePermissionEntity entity = new SysConRolePermissionEntity();
            entity.setId(IdUtil.getId());
            entity.setRoleId(roleId);
            entity.setPermissionId(permissionId);
            list.add(entity);
            sysConRolePermissionDao.insert(entity);
        }
        // addCount = sysConRolePermissionDao.batchAddRolePermission(list);
        return ResultUtil.OK("分配权限成功");
    }
}
