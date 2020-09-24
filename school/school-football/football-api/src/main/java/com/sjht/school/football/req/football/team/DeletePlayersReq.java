package com.sjht.school.football.req.football.team;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName DeletePlayers
 * @Description 描述
 * @Author 张弛
 * @Date 2019/9/12 16:58
 * @Version V1.0
 * ****************************************************
 **/
public class DeletePlayersReq implements Serializable {

    private String teamId;
    private String studentId;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}
