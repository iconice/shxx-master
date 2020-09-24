package com.sjht.school.football.entity.football.team;

import com.baomidou.mybatisplus.annotations.TableName;
import com.sjht.school.common.entity.BaseEntity;

/**
 * ***************************************************
 * @ClassName TeamPlayersEntity
 * @Description 球队成员实体类
 * @Author maojianyun
 * @Date 2019/9/10 9:21
 * @Version V1.0
 * ****************************************************
 **/
@TableName("football_con_team_players")
public class TeamPlayersEntity extends BaseEntity {

    private String studentId;

    private String teamId;

    private Integer score;

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
