package com.sjht.school.football.resp.football.statistical;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName GetScoreboarListResp
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/10/22 12:08
 * @Version V1.0
 * ****************************************************
 **/
public class GetScoreboarListResp implements Serializable {

    private String teamId;

    private String teamName;

    private String gradeName;

    private String className;

    private Integer score;

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

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
