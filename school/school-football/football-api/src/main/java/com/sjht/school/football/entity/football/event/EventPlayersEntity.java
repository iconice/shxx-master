package com.sjht.school.football.entity.football.event;

import com.baomidou.mybatisplus.annotations.TableName;
import com.sjht.school.common.entity.BaseEntity;

/**
 * ***************************************************
 * @ClassName EventPlayersEntity
 * @Description 赛事成员
 * @Author maojianyun
 * @Date 2019/9/29 8:14
 * @Version V1.0
 * ****************************************************
 **/
@TableName("football_con_event_players")
public class EventPlayersEntity extends BaseEntity {

    private String eventId;

    private String studentId;

    private String teamId;

    private Integer score;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
