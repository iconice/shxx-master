package com.sjht.school.football.resp.football.student;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName GetClassListResp
 * @Description 得到班级信息列表
 * @Author maojianyun
 * @Date 2019/9/5 22:56
 * @Version V1.0
 * ****************************************************
 **/
public class GetClassListResp implements Serializable {

    private String classId;

    private String period;

    private String className;

    private Integer isSelect;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(Integer isSelect) {
        this.isSelect = isSelect;
    }
}
