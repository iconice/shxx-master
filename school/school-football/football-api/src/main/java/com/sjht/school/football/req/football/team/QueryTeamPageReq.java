package com.sjht.school.football.req.football.team;

import com.sjht.school.common.entity.PageBase;

/**
 * ***************************************************
 *
 * @ClassName QueryTeamPageReq
 * @Description
 * @Author 张弛
 * @Date 2019/9/10 12:04
 * @Version V1.0
 * ****************************************************
 **/
public class QueryTeamPageReq extends PageBase{

    private String teamName;

    private String count;

    private String userId;

    private String teamType;

    private String gradeId;

    private String classId;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTeamType() {
        return teamType;
    }

    public void setTeamType(String teamType) {
        this.teamType = teamType;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}

