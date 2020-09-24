package com.sjht.school.football.req.football.site;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName SubmitEditSiteReq
 * @Description 提交编辑请求
 * @Author maojianyun
 * @Date 2019/9/7 18:42
 * @Version V1.0
 * ****************************************************
 **/
public class SubmitEditSiteReq implements Serializable {

    private String siteId;

    private String siteName;

    private String siteType;

    private String location;

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

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
