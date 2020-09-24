package com.sjht.school.football.dao.football.student;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sjht.school.football.entity.football.student.ClassEntity;
import com.sjht.school.football.req.football.student.SubmitEditClassReq;
import com.sjht.school.football.resp.football.student.GetClassListResp;
import com.sjht.school.football.resp.football.student.GetClassInfoResp;
import com.sjht.school.football.resp.football.student.QueryClassPageResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName ClassDao
 * @Description 班级数据层
 * @Author maojianyun
 * @Date 2019/9/5 10:39
 * @Version V1.0
 * ****************************************************
 **/
@Controller
@Mapper
public interface ClassDao extends BaseMapper<ClassEntity> {

    /**
     * 班级分页查询列表
     * @param page
     * @param params
     * @return
     */
    List<QueryClassPageResp> queryClassPageList(Page<QueryClassPageResp> page, @Param("params") Map<String, Object> params);

    /**
     * 班级分页查询数量
     * @param params
     * @return
     */
    long queryClassPageCount(@Param("params") Map<String, Object> params);

    /**
     * 得到队伍信息
     * @param classId
     * @return
     */
    GetClassInfoResp getClassInfo(@Param("classId") String classId);

    /**
     * 提交编辑
     * @param editClassReq
     * @return
     */
    int updateClassByClassId(@Param("ew") SubmitEditClassReq editClassReq);

    /**
     * 得到班级列表
     * @param params
     * @return
     */
    List<GetClassListResp> getClassList(@Param("params")Map<String, Object> params);

    /**
     * 得到班级列表
     * @param userId
     * @param period
     * @return
     */
    List<GetClassListResp> getClassSelectList(@Param("userId")String userId, @Param("period")String period);

    /**
     * 得到届
     * @param userId
     * @return
     */
    List<String> getPeriodList(@Param("userId")String userId);
}
