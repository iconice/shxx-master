package com.sjht.school.football.req.football.event;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName AddEventScoreReq
 * @Description 添加比分
 * @Author maojianyun
 * @Date 2019/9/14 14:37
 * @Version V1.0
 * ****************************************************
 **/
public class AddEventScoreReq implements Serializable {

    private String eventId;

    private String team1Score;

    private String team2Score;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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
