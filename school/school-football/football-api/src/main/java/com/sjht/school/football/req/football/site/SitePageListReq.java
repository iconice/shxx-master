package com.sjht.school.football.req.football.site;

import com.sjht.school.common.entity.PageBase;

/**
 * ***************************************************
 *
 * @ClassName SitePageListReq
 * @Description 场地分页查询请求
 * @Author maojianyun
 * @Date 2019/9/6 20:48
 * @Version V1.0
 * ****************************************************
 **/
public class SitePageListReq extends PageBase {

    private String siteType;

    private String siteName;

    private String location;

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
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
}
