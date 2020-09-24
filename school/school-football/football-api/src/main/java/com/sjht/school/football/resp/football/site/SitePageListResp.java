package com.sjht.school.football.resp.football.site;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName SitePageListResp
 * @Description 场地分页查询响应
 * @Author maojianyun
 * @Date 2019/9/6 20:45
 * @Version V1.0
 * ****************************************************
 **/
public class SitePageListResp implements Serializable {

    private String siteId;

    private String siteName;

    private String location;

    private String status;

    private String siteType;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }
}
