package com.sjht.school.football.req.football.team;

import java.io.Serializable;

/**
 * ***************************************************
 *
 * @ClassName AddTeamReq
 * @Description 描述
 * @Author 张弛
 * @Date 2019/9/11 9:15
 * @Version V1.0
 * ****************************************************
 **/
public class AddTeamReq implements Serializable {

    private  String userId;

    private String classId;

    private String gradeId;

    private  String teamName;

    private  Integer count;

    private  Integer teamType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTeamType() {
        return teamType;
    }

    public void setTeamType(Integer teamType) {
        this.teamType = teamType;
    }
}
