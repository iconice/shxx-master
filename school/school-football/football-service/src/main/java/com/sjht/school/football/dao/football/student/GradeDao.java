package com.sjht.school.football.dao.football.student;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sjht.school.football.entity.football.student.GradeEntity;
import com.sjht.school.football.resp.football.student.GradeResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface GradeDao extends BaseMapper<GradeEntity> {

    /**
     * 得到年级列表
     * @return
     */
    List<GradeResp> getgradeList();

    /**
     * 得到用户的年级
     * @param userId
     * @return
     */
    List<GradeResp> getUserGradeList(@Param("userId")String userId);

    /**
     * 通过用户id得到其年级
     * @param userId
     * @return
     */
    List<GradeResp> getGradeListByUserId(@Param("userId")String userId);
}
