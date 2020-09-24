package com.sjht.school.football.resp.football.event;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName AddScoreResp
 * @Description 添加分数响应
 * @Author maojianyun
 * @Date 2019/9/11 9:43
 * @Version V1.0
 * ****************************************************
 **/
public class AddScoreResp implements Serializable {

    private String eventId;

    private String eventName;

    private String team1Id;

    private String team2Id;

    private String team1Name;

    private String team2Name;

    private Integer team1Score;

    private Integer team2Score;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getTeam1Id() {
        return team1Id;
    }

    public void setTeam1Id(String team1Id) {
        this.team1Id = team1Id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getTeam2Id() {
        return team2Id;
    }

    public void setTeam2Id(String team2Id) {
        this.team2Id = team2Id;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    public Integer getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(Integer team1Score) {
        this.team1Score = team1Score;
    }

    public Integer getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(Integer team2Score) {
        this.team2Score = team2Score;
    }
}
