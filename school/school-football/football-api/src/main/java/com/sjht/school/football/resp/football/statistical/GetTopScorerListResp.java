package com.sjht.school.football.resp.football.statistical;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName GetTopScorerListResp
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/10/22 9:53
 * @Version V1.0
 * ****************************************************
 **/
public class GetTopScorerListResp implements Serializable {

    private String studentId;

    private String gradeName;

    private String className;

    private String studentName;

    private String teamName;

    private Integer score;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
