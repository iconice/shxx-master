package com.sjht.school.football.resp.football.team;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName GetTeamUsersResp
 * @Description 得到球队成员响应
 * @Author maojianyun
 * @Date 2019/9/11 11:15
 * @Version V1.0
 * ****************************************************
 **/
public class GetTeamUsersResp implements Serializable {

    private String id;

    private String studentId;

    private String teamName;

    private String studentName;

    private Integer score;

    private String eventId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
