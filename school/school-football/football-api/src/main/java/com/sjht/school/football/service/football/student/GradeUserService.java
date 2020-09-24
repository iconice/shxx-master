package com.sjht.school.football.service.football.student;

import com.sjht.school.football.entity.football.student.GradeUserEntity;

import java.util.List;

/**
 * ***************************************************
 * @ClassName GradeUserService
 * @Description 班级老师关联接口
 * @Author maojianyun
 * @Date 2019/9/20 14:52
 * @Version V1.0
 * ****************************************************
 **/
public interface GradeUserService {

    public boolean batchInsert(List<GradeUserEntity> userEntities);

    public boolean batchDelete(String userId);
}
