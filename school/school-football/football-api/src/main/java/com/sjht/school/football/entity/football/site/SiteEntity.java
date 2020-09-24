package com.sjht.school.football.entity.football.site;

import com.baomidou.mybatisplus.annotations.TableName;
import com.sjht.school.common.entity.BaseEntity;

/**
 * ***************************************************
 * @ClassName SiteEntity
 * @Description 场地实体类
 * @Author maojianyun
 * @Date 2019/9/5 23:24
 * @Version V1.0
 * ****************************************************
 **/
@TableName("football_base_site")
public class SiteEntity extends BaseEntity {

    private String siteName;

    private String location;

    private String siteType;

    private String status;

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

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
