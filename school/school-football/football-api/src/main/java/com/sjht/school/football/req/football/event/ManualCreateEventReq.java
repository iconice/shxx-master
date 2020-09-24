package com.sjht.school.football.req.football.event;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ***************************************************
 * @ClassName ManualCreateEventReq
 * @Description 创建赛事请求类
 * @Author maojianyun
 * @Date 2019/9/10 17:01
 * @Version V1.0
 * ****************************************************
 **/
public class ManualCreateEventReq implements Serializable {

    private Integer category;
    private String team1Id;
    private String team2Id;
    private String gradeId;
    private String classId;
    private String siteId;
    private String seasonId;
    private Integer batchNo;

    private Integer type;

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
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

    public String getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(String seasonId) {
        this.seasonId = seasonId;
    }

    public Integer getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(Integer batchNo) {
        this.batchNo = batchNo;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
