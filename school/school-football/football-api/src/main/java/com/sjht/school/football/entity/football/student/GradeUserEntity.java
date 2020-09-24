package com.sjht.school.football.entity.football.student;

import com.baomidou.mybatisplus.annotations.TableName;
import com.sjht.school.common.entity.BaseEntity;

/**
 * ***************************************************
 * @ClassName GradeUserEntity
 * @Description 老师班级关联表实体
 * @Author maojianyun
 * @Date 2019/9/20 14:43
 * @Version V1.0
 * ****************************************************
 **/
@TableName("base_con_grade_user")
public class GradeUserEntity extends BaseEntity {

    private String userId;

    private String gradeId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }
}
