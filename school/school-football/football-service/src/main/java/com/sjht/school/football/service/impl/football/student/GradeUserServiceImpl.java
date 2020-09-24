package com.sjht.school.football.service.impl.football.student;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sjht.school.football.dao.football.student.GradeUserDao;
import com.sjht.school.football.entity.football.student.GradeUserEntity;
import com.sjht.school.football.service.football.student.GradeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ***************************************************
 * @ClassName GradeUserServiceImpl
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/9/20 14:52
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class GradeUserServiceImpl extends ServiceImpl<GradeUserDao, GradeUserEntity> implements IService<GradeUserEntity>, GradeUserService {


    @Autowired
    private GradeUserDao classUserDao;

    @Override
    public boolean batchInsert(List<GradeUserEntity> userEntities) {
        return this.insertBatch(userEntities);
    }

    @Transactional
    @Override
    public boolean batchDelete(String userId) {
        Wrapper<GradeUserEntity> wrapper = new EntityWrapper<>();
        wrapper.where("user_id={0}", userId);
        this.delete(wrapper);
        return true;
    }
}
