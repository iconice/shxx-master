package com.sjht.school.football.resp.football.student;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName QueryClassPageResp
 * @Description 分页查询班级请求
 * @Author maojianyun
 * @Date 2019/9/5 10:48
 * @Version V1.0
 * ****************************************************
 **/
public class QueryClassPageResp implements Serializable {

    private String classId;

    private String period;

    private String className;

    private String leaderName;

    private String teacher;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
