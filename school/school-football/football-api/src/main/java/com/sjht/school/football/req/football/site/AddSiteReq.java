package com.sjht.school.football.req.football.site;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName AddSiteReq
 * @Description 添加场地
 * @Author maojianyun
 * @Date 2019/9/6 21:51
 * @Version V1.0
 * ****************************************************
 **/
public class AddSiteReq implements Serializable {

    private String siteName;

    private String siteType;

    private String location;

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
