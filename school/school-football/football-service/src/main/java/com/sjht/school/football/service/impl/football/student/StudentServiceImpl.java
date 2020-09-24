package com.sjht.school.football.service.impl.football.student;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.common.entity.ResultUtil;
import com.sjht.school.common.utils.IdUtil;
import com.sjht.school.common.utils.PageUtil;
import com.sjht.school.football.dao.football.student.StudentDao;
import com.sjht.school.football.entity.football.student.StudentEntity;
import com.sjht.school.football.req.football.student.AddStudentReq;
import com.sjht.school.football.req.football.student.QueryStudentPageReq;
import com.sjht.school.football.req.football.student.SubmitEditStudentReq;
import com.sjht.school.football.resp.football.student.GetStudentListResp;
import com.sjht.school.football.resp.football.student.QueryStudentPageResp;
import com.sjht.school.football.service.football.student.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements IService<StudentEntity>, StudentService {

    @Autowired
    private StudentDao studentDao;


    @Override
    public PageResult<QueryStudentPageResp> queryStudentPageList(QueryStudentPageReq queryStudentPageReq) {
        Map<String, Object> params = new HashMap<>();
        PageResult<QueryStudentPageResp> pageResult = new PageResult<>();
        Integer pageNo = Integer.valueOf(PageUtil.getPageNo(queryStudentPageReq.getLimit(), queryStudentPageReq.getOffset()));
        Integer pageSize = Integer.valueOf(queryStudentPageReq.getLimit());
        Page<QueryStudentPageResp> page = new Page<>(pageNo, pageSize);
        List<QueryStudentPageResp> datas = new ArrayList<>();
        if (StringUtils.isNotBlank(queryStudentPageReq.getClassId())) {
            params.put("classId", queryStudentPageReq.getClassId());
        }
        if (StringUtils.isNotBlank(queryStudentPageReq.getName())) {
            params.put("name", queryStudentPageReq.getName());
        }
        if (StringUtils.isNotBlank(queryStudentPageReq.getSex()) ){
            params.put("sex", queryStudentPageReq.getSex());
        }
        if (StringUtils.isNotBlank(queryStudentPageReq.getGradeId()) ){
            params.put("gradeId", queryStudentPageReq.getGradeId());
        }
        long count = studentDao.queryStudentPageCount(params);
        if (count > 0) {
            datas = studentDao.queryStudentPageList(page, params);
        }
        return pageResult.resultPage(datas, count);
    }

    @Override
    public BaseResponse addStudent(AddStudentReq addStudentReq) {

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(IdUtil.getId());
        studentEntity.setClassId(addStudentReq.getClassId());
        studentEntity.setName(addStudentReq.getName());
        studentEntity.setSex(addStudentReq.getSex());
        studentEntity.setHeight(addStudentReq.getHeight());
        studentEntity.setWeight(addStudentReq.getWeight());
        studentEntity.setAge(addStudentReq.getAge());
        this.insert(studentEntity);
        return ResultUtil.OK("添加成功");
    }

    @Override
    public BaseResponse deleteStudent(String studentId) {
        this.deleteById(studentId);
        return ResultUtil.OK("删除成功");
    }

    @Override
    public StudentEntity studentInfo(String studentId) {
        return this.selectById(studentId);
    }

    @Override
    public BaseResponse submitEditStudent(SubmitEditStudentReq submitEditStudentReq) {
        studentDao.updateByStudentId(submitEditStudentReq);
        return ResultUtil.OK("编辑成功");
    }

    @Override
    public List<GetStudentListResp> getStudentList(Map<String, Object> params) {
        return studentDao.getStudentList(params);
    }
}