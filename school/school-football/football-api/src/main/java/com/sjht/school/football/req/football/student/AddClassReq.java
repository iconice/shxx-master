package com.sjht.school.football.req.football.student;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName AddClassReq
 * @Description 添加班级请求类
 * @Author maojianyun
 * @Date 2019/9/5 14:19
 * @Version V1.0
 * ****************************************************
 **/
public class AddClassReq implements Serializable {

    private String userId;

    private String className;

    private String gradeId;

    private String leaderName;

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

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }
}
