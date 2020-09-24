package com.sjht.school.football.entity.football.team;

import com.baomidou.mybatisplus.annotations.TableName;
import com.sjht.school.common.entity.BaseEntity;

/**
 * ***************************************************
 * @ClassName TeamEntity
 * @Description 球队实体类
 * @Author maojianyun
 * @Date 2019/9/10 8:58
 * @Version V1.0
 * ****************************************************
 **/
@TableName("football_base_team")
public class TeamEntity extends BaseEntity {

    private String userId;

    private String classId;

    private String gradeId;

    private String teamName;

    private Integer count;

    private Integer teamType;

    private Integer score;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTeamType() {
        return teamType;
    }

    public void setTeamType(Integer teamType) {
        this.teamType = teamType;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
