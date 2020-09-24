package com.sjht.school.football.req.football.student;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName SubmitEditClassReq
 * @Description 提交班级编辑
 * @Author maojianyun
 * @Date 2019/9/5 15:57
 * @Version V1.0
 * ****************************************************
 **/
public class SubmitEditClassReq implements Serializable {

    private String classId;

    private String className;

    private String leaderName;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
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
}
