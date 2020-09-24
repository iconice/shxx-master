package com.sjht.school.football.dao.sys;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sjht.school.football.entity.SysConUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
/**
 ************************************************
 *@ClassName SysConUserRoleDao
 *@Description 角色用户数据层
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
@Component
@Mapper
public interface SysConUserRoleDao extends BaseMapper<SysConUserRoleEntity> {
}
