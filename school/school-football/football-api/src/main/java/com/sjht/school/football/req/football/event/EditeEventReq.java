package com.sjht.school.football.req.football.event;

import java.io.Serializable;

/**
 * ***************************************************
 *
 * @ClassName EditeEventReq
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/9/26 12:06
 * @Version V1.0
 * ****************************************************
 **/
public class EditeEventReq implements Serializable {
    private String eventId;
    private String siteId;
    private Integer batchNo;
    private String status;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public Integer getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(Integer batchNo) {
        this.batchNo = batchNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
