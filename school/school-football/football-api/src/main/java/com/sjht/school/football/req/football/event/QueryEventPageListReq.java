package com.sjht.school.football.req.football.event;

import com.sjht.school.common.entity.PageBase;

import java.util.Date;

/**
 * ***************************************************
 * @ClassName QueryEventPageListReq
 * @Description 赛事分页查询请求
 * @Author maojianyun
 * @Date 2019/9/10 11:17
 * @Version V1.0
 * ****************************************************
 **/
public class QueryEventPageListReq extends PageBase {

    private String userId;

    private Integer batchNo;

    private String eventName;

    private Integer category;

    private String teamName;

    private Date startTime;

    private Date endTime;

    private Integer type;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(Integer batchNo) {
        this.batchNo = batchNo;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
