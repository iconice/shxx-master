package com.sjht.school.football.req.football.event;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ***************************************************
 * @ClassName AutoCreateEventReq
 * @Description 创建赛事请求类
 * @Author maojianyun
 * @Date 2019/9/10 17:01
 * @Version V1.0
 * ****************************************************
 **/
public class AutoCreateEventReq implements Serializable {

    private String seasonId;

    private String eventName;

    private Integer category;

    private Integer type;

    private String gradeId;

    private String classId;

    private String siteId;

    private String team1Id;

    private String team2Id;

    private String team2IsStr;

    private Date startTime;

    private Date endTime;

    private List<String> siteIds;

    public String getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(String seasonId) {
        this.seasonId = seasonId;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getTeam1Id() {
        return team1Id;
    }

    public void setTeam1Id(String team1Id) {
        this.team1Id = team1Id;
    }

    public String getTeam2Id() {
        return team2Id;
    }

    public void setTeam2Id(String team2Id) {
        this.team2Id = team2Id;
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

    public String getTeam2IsStr() {
        return team2IsStr;
    }

    public void setTeam2IsStr(String team2IsStr) {
        this.team2IsStr = team2IsStr;
    }

    public List<String> getSiteIds() {
        return siteIds;
    }

    public void setSiteIds(List<String> siteIds) {
        this.siteIds = siteIds;
    }
}
