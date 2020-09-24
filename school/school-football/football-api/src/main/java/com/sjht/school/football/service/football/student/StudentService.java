package com.sjht.school.football.service.football.student;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.football.entity.football.student.StudentEntity;
import com.sjht.school.football.req.football.student.AddStudentReq;
import com.sjht.school.football.req.football.student.QueryStudentPageReq;
import com.sjht.school.football.req.football.student.SubmitEditStudentReq;
import com.sjht.school.football.resp.football.student.GetStudentListResp;
import com.sjht.school.football.resp.football.student.QueryStudentPageResp;

import java.util.List;
import java.util.Map;

/**
 * ***********************************************
 *
 * @ClassName StudentService
 * @Description 班级接口
 * @Author 张弛
 * @Date2019/9/5 22:43
 * @Version V1.0
 * ************************************************
 **/
public interface StudentService {

    /**
     * 分页查询学生
     *
     * @param queryStudentPageReq
     * @return
     */

    PageResult<QueryStudentPageResp> queryStudentPageList(QueryStudentPageReq queryStudentPageReq);

    /**
     * 添加学生
     *
     * @param addStudentReq
     * @return
     */

    BaseResponse addStudent(AddStudentReq addStudentReq);

    /**
     * 删除学生
     *
     * @param studentId
     * @return
     */
    BaseResponse deleteStudent(String studentId);

    /**
     * 得到学生信息
     * @param studentId
     * @return
     */
    StudentEntity studentInfo(String studentId);

    /**
     * 提交编辑
     *
     * @param submitEditStudentReq
     * @return
     */
    BaseResponse submitEditStudent(SubmitEditStudentReq submitEditStudentReq);

    /**
     * 得到学生列表
     * @param params
     * @return
     */
    List<GetStudentListResp> getStudentList(Map<String, Object> params);
}