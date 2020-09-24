package com.sjht.school.football.req.football.statistical;

import com.sjht.school.common.entity.PageBase;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName GetTopScorerListResp
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/10/22 9:53
 * @Version V1.0
 * ****************************************************
 **/
public class GetTopScorerListReq extends PageBase implements Serializable {

    private String gradeId;

    private String classId;

    private Integer teamType;

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

    public Integer getTeamType() {
        return teamType;
    }

    public void setTeamType(Integer teamType) {
        this.teamType = teamType;
    }
}
