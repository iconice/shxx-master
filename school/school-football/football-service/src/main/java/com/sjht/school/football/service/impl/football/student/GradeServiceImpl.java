package com.sjht.school.football.service.impl.football.student;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.ObjectResponse;
import com.sjht.school.football.dao.football.student.GradeDao;
import com.sjht.school.football.entity.football.student.GradeEntity;
import com.sjht.school.football.resp.football.student.GradeResp;
import com.sjht.school.football.service.football.student.GradeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ***************************************************
 * @ClassName GradeServiceImpl
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/9/23 9:14
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class GradeServiceImpl extends ServiceImpl<GradeDao, GradeEntity> implements IService<GradeEntity>, GradeService {

    @Autowired
    private GradeDao gradeDao;

    @Override
    public ObjectResponse getgradeList(String userId) {
        ObjectResponse response = new ObjectResponse();
        List<GradeResp> data = gradeDao.getGradeListByUserId(userId);
        response.OK(data);
        return response;
    }

    @Override
    public BaseResponse getUserGradeList(String userId) {
        ObjectResponse response = new ObjectResponse();
        List<GradeResp> data = gradeDao.getUserGradeList(userId);
        return response.OK(data);
    }
}
