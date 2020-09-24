package com.sjht.school.football.req.football.event;

/**
 * ***************************************************
 *
 * @ClassName EventInfoReq
 * @Description 描述
 * @Author 张弛
 * @Date 2019/9/18 16:48
 * @Version V1.0
 * ****************************************************
 **/
public class EventInfoReq {
    private String teamName;
    private String type;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
