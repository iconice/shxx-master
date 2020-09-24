package com.sjht.school.football.resp.football.event;

import java.io.Serializable;

/**
 * ***************************************************
 *
 * @ClassName EventInfoResp
 * @Description 描述
 * @Author 张弛
 * @Date 2019/9/18 16:14
 * @Version V1.0
 * ****************************************************
 **/
public class EventInfoResp implements Serializable {
    private String team1Name;
    private String team2Name;
    private String period;
    private String className;
    private String eventName;
    private String eventId;
    private String type;
    private String status;// 赛事是否结束   0结束 1没有
    private String team1Score; //球队1分数
    private String team2Score; //球队2分数

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

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(String team1Score) {
        this.team1Score = team1Score;
    }

    public String getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(String team2Score) {
        this.team2Score = team2Score;
    }
}
