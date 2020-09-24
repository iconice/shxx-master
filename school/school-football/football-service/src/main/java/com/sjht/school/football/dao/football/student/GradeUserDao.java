package com.sjht.school.football.dao.football.student;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sjht.school.football.entity.football.student.GradeUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * ***************************************************
 * @ClassName ClassUserDao
 * @Description 班级老体育老师关联表
 * @Author maojianyun
 * @Date 2019/9/20 14:45
 * @Version V1.0
 * ****************************************************
 **/
@Component
@Mapper
public interface GradeUserDao extends BaseMapper<GradeUserEntity> {
}
