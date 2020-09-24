package com.sjht.school.football.resp.football.team;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName GetPlayersListResp
 * @Description 得到球员列表
 * @Author maojianyun
 * @Date 2019/9/12 14:23
 * @Version V1.0
 * ****************************************************
 **/
public class GetPlayersListResp implements Serializable {

    private String studentId;

    private String studentName;

    private Integer sex;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
