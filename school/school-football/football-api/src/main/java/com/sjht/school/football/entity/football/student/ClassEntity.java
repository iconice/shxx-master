package com.sjht.school.football.entity.football.student;

import com.baomidou.mybatisplus.annotations.TableName;
import com.sjht.school.common.entity.BaseEntity;

/**
 ************************************************
 *@ClassName ClassEntity
 *@Description 班级实体类
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
@TableName("base_class")
public class ClassEntity extends BaseEntity {

    /**
     * 所属届
     */
    private String  gradeId;
    /**
     * 班主任id
     */
    private String  leaderName;

    /**
     * 体育老师id
     */
    private String  userId;

    /**
     * 班级名称
     */
    private String  className;

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}

