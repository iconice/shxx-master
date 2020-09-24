package com.sjht.school.football.req.football.team;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName UpdatePlayersScoreReq
 * @Description 更新个人的分数
 * @Author maojianyun
 * @Date 2019/9/14 20:01
 * @Version V1.0
 * ****************************************************
 **/
public class UpdatePlayersScoreReq implements Serializable {

    private String id;

    private String studentId;

    private String operation;

    private int score;

    private String eventId;

    private int team;

    private String teamId;

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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}
