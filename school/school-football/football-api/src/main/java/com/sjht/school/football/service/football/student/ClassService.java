package com.sjht.school.football.service.football.student;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.football.entity.football.student.ClassEntity;
import com.sjht.school.football.req.football.student.AddClassReq;
import com.sjht.school.football.req.football.student.QueryClassPageReq;
import com.sjht.school.football.req.football.student.SubmitEditClassReq;
import com.sjht.school.football.resp.football.student.GetClassInfoResp;
import com.sjht.school.football.resp.football.student.GetClassListResp;
import com.sjht.school.football.resp.football.student.QueryClassPageResp;

import java.util.List;
import java.util.Map;

/**
 ************************************************
 *@ClassName ClassService
 *@Description 班级接口
 *@Author maojianyun
 *@Date2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
public interface ClassService {

    /**
     * 分页查询
     * @param classPageReq
     * @return
     */
    PageResult<QueryClassPageResp> queryClassPageList(QueryClassPageReq classPageReq);

    /**
     * 添加班级
     * @param addClassReq
     * @return
     */
    BaseResponse addClass(AddClassReq addClassReq);

    /**
     * 删除班级
     * @param classId
     * @return
     */
    BaseResponse deleteClass(String classId);

    /**
     * 查询班级信息
     * @param classId
     * @return
     */
    GetClassInfoResp getClassInfo(String classId);

    /**
     * 提交编辑
     * @param editClassReq
     * @return
     */
    BaseResponse submitEdit(SubmitEditClassReq editClassReq);

    /**
     * 得到班级列表
     * @param params
     * @return
     */
    List<GetClassListResp> getClassList(Map<String, Object> params);

    /**
     * 得到届列表
     * @param userId
     * @return
     */
    List<String> getPeriodList(String userId);

    BaseResponse getPeriodClass();

    BaseResponse getClassSelectList(String userId);
}
