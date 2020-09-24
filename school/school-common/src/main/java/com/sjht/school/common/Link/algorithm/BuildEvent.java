package com.sjht.school.common.Link.algorithm;

/**
 * ***************************************************
 * @ClassName BuildEvent
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/9/30 16:53
 * @Version V1.0
 * ****************************************************
 **/
public class BuildEvent {

    private Integer batchNo;

    private String siteId;

    private String team1Id;

    private String team2Id;

    public Integer getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(Integer batchNo) {
        this.batchNo = batchNo;
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
}
