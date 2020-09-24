package com.sjht.school.football.req.football.student;

import com.sjht.school.common.entity.PageBase;

/**
 * ***************************************************
 *
 * @ClassName QueryClassPageResp
 * @Description 分页查询班级请求
 * @Author maojianyun
 * @Date 2019/9/5 10:48
 * @Version V1.0
 * ****************************************************
 **/
public class QueryClassPageReq extends PageBase {

    private String gradeId;

    private String className;

    private String userId;

    private String leaderName;

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }
}
