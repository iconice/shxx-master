package com.sjht.school.football.dao.football.student;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sjht.school.football.entity.football.student.StudentEntity;
import com.sjht.school.football.req.football.student.SubmitEditStudentReq;
import com.sjht.school.football.req.football.team.UpdatePlayersScoreReq;
import com.sjht.school.football.resp.football.student.GetStudentListResp;
import com.sjht.school.football.resp.football.student.QueryStudentPageResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {

    /**
     * 班级分页查询列表
     * @param page
     * @param params
     * @return
     */
    List<QueryStudentPageResp> queryStudentPageList(Page<QueryStudentPageResp> page, @Param("params") Map<String, Object> params);

    /**
     * 学生分页查询数量
     * @param params
     * @return
     */
    long queryStudentPageCount(@Param("params") Map<String, Object> params);

    /**
     * 提交编辑
     * @param editStudentReq
     * @return
     */
    int updateByStudentId(@Param("ew") SubmitEditStudentReq editStudentReq);

    /**
     * 得到学生列表
     * @param params
     * @return
     */
    List<GetStudentListResp> getStudentList(@Param("params") Map<String, Object> params);

    /**
     * 跟新学生分数
     * @param playersScoreReq
     * @return
     */
    int updateStudentScore(@Param("ew") UpdatePlayersScoreReq playersScoreReq);
}
