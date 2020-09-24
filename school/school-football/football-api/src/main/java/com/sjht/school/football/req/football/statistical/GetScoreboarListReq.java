package com.sjht.school.football.req.football.statistical;

import com.sjht.school.common.entity.PageBase;

import java.io.Serializable;

/**
 * ***************************************************
 *
 * @ClassName GetScoreboarListReq
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/10/22 12:15
 * @Version V1.0
 * ****************************************************
 **/
public class GetScoreboarListReq extends PageBase implements Serializable {

    private Integer teamType;

    private String gradeId;

    private String classId;

    public Integer getTeamType() {
        return teamType;
    }

    public void setTeamType(Integer teamType) {
        this.teamType = teamType;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}

