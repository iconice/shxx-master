package com.sjht.school.football.entity.common;

import com.baomidou.mybatisplus.annotations.TableName;
import com.sjht.school.common.entity.BaseEntity;

/**
 * ***************************************************
 *
 * @ClassName SeasonEntity
 * @Description 赛程实体类
 * @Author maojianyun
 * @Date 2019/10/10 14:07
 * @Version V1.0
 * ****************************************************
 **/
@TableName("base_season")
public class SeasonEntity extends BaseEntity {

    private String year;

    private String term;

    private String parentId;

    private String seName;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getSeName() {
        return seName;
    }

    public void setSeName(String seName) {
        this.seName = seName;
    }
}
