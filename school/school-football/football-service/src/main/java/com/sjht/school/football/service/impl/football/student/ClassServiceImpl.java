package com.sjht.school.football.service.impl.football.student;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.ObjectResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.common.entity.ResultUtil;
import com.sjht.school.common.utils.IdUtil;
import com.sjht.school.common.utils.PageUtil;
import com.sjht.school.football.dao.football.student.ClassDao;
import com.sjht.school.football.entity.SysUserEntity;
import com.sjht.school.football.entity.football.student.ClassEntity;
import com.sjht.school.football.req.football.student.AddClassReq;
import com.sjht.school.football.req.football.student.QueryClassPageReq;
import com.sjht.school.football.req.football.student.SubmitEditClassReq;
import com.sjht.school.football.resp.football.student.GetClassInfoResp;
import com.sjht.school.football.resp.football.student.GetClassListResp;
import com.sjht.school.football.resp.football.student.QueryClassPageResp;
import com.sjht.school.football.service.football.student.ClassService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName ClassServiceImpl
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/9/5 10:44
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class ClassServiceImpl extends ServiceImpl<ClassDao, ClassEntity> implements IService<ClassEntity>, ClassService {

    @Autowired
    private ClassDao classDao;

    @Override
    public PageResult<QueryClassPageResp> queryClassPageList(QueryClassPageReq classPageReq) {
        Map<String, Object> params = new HashMap<>();
        PageResult pageResult = new PageResult();
        Integer pageNo = Integer.valueOf(PageUtil.getPageNo(classPageReq.getLimit(), classPageReq.getOffset()));
        Integer pageSize = Integer.valueOf(classPageReq.getLimit());
        Page<QueryClassPageResp> page = new Page<>(pageNo, pageSize);

        List<QueryClassPageResp> datas = new ArrayList<>();

        if (StringUtils.isNotBlank(classPageReq.getUserId())) {
            params.put("userId", classPageReq.getUserId());
        }
        if (StringUtils.isNotBlank(classPageReq.getGradeId())) {
            params.put("gradeId", classPageReq.getGradeId());
        }
        if (StringUtils.isNotBlank(classPageReq.getClassName())) {
            params.put("className", classPageReq.getClassName());
        }
        if (StringUtils.isNotBlank(classPageReq.getLeaderName())) {
            params.put("leaderName", classPageReq.getLeaderName());
        }
        long count = classDao.queryClassPageCount(params);
        if (count > 0) {
            datas = classDao.queryClassPageList(page, params);
        }
        return pageResult.resultPage(datas, count);
    }

    @Override
    public BaseResponse addClass(AddClassReq addClassReq) {
        ClassEntity classEntity = new ClassEntity();
        classEntity.setId(IdUtil.getId());
        classEntity.setUserId(addClassReq.getUserId());
        classEntity.setGradeId(addClassReq.getGradeId());
        classEntity.setClassName(addClassReq.getClassName());
        classEntity.setLeaderName(addClassReq.getLeaderName());
        this.insert(classEntity);
        return ResultUtil.OK("添加成功");
    }

    @Override
    public BaseResponse deleteClass(String classId) {
        this.deleteById(classId);
        return ResultUtil.OK("删除成功");
    }

    @Override
    public GetClassInfoResp getClassInfo(String classId) {
        return classDao.getClassInfo(classId);
    }

    @Override
    public BaseResponse submitEdit(SubmitEditClassReq editClassReq) {
        classDao.updateClassByClassId(editClassReq);
        return ResultUtil.OK("编辑成功");
    }

    @Override
    public List<GetClassListResp> getClassList(Map<String, Object> params) {
        return classDao.getClassList(params);
    }

    @Override
    public List<String> getPeriodList(String userId) {
        return classDao.getPeriodList(userId);
    }

    @Override
    public BaseResponse getPeriodClass() {
        ObjectResponse response = new ObjectResponse();
        // 得到所有的届
        List<String> periodList = classDao.getPeriodList(null);
        Map<String, List<GetClassListResp>> maps = new HashMap<>();
        for(String period: periodList){
            // 根据届得到班级
            // List<GetClassListResp> classList = classDao.getClassList(null, period);
            // maps.put(period, classList);
        }
        return response.OK(maps);
    }

    @Override
    public BaseResponse getClassSelectList(String userId) {
        ObjectResponse response = new ObjectResponse();
        // 得到所有的届
        List<String> periodList = classDao.getPeriodList(null);
        Map<String, List<GetClassListResp>> maps = new HashMap<>();
        for(String period: periodList){
            // 根据届得到班级
            List<GetClassListResp> classList = classDao.getClassSelectList(userId, period);
            maps.put(period, classList);
        }
        return response.OK(maps);
    }

    public static void main(String[] args) {
        for(int i = 0; i< 5; i++){
            if (i == 0) {
                System.err.println(i);
            }
        }
    }
}
