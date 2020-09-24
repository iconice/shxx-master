package com.sjht.school.football.resp.football.student;

import java.io.Serializable;

/**
 * 年级响应实体
 */
public class GradeResp implements Serializable {

    private String gradeId;

    private String gradeName;

    private Integer isSelect;

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Integer getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(Integer isSelect) {
        this.isSelect = isSelect;
    }
}
