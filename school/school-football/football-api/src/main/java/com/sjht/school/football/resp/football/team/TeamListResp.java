package com.sjht.school.football.resp.football.team;

import java.io.Serializable;

/**
 * ***************************************************
 *
 * @ClassName GetTeamListResp
 * @Description 得到球队列表
 * @Author 张弛
 * @Date 2019/9/10 9:28
 * @Version V1.0
 * ****************************************************
 **/
public class TeamListResp implements Serializable {

    private String teamId;

    private String teamName;

    private String classId;

    private String gradeId;

    private Integer isChoose = 0;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getIsChoose() {
        return isChoose;
    }

    public void setIsChoose(Integer isChoose) {
        this.isChoose = isChoose;
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
}
