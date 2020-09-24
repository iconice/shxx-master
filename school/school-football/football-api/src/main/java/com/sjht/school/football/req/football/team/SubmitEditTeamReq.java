package com.sjht.school.football.req.football.team;

import java.io.Serializable;

/**
 * ***************************************************
 *
 * @ClassName SubmitEditTeamReq
 * @Description 编辑提交学生请求
 * @Author 张弛
 * @Date 2019/9/11 10:21
 * @Version V1.0
 * ****************************************************
 **/
public class SubmitEditTeamReq implements Serializable {
    private String id;
    private String userId;
    private String teamName;
    private Integer count;
    private Integer teamType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTeamType() {
        return teamType;
    }

    public void setTeamType(Integer teamType) {
        this.teamType = teamType;
    }
}
