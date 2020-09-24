package com.sjht.school.football.req.football.student;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName EditUserReq
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/9/22 9:34
 * @Version V1.0
 * ****************************************************
 **/
public class EditUserReq implements Serializable {

    private String id;

    private String tell;

    private String email;

    private String status;

    private String gradeIds;

    private Integer type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGradeIds() {
        return gradeIds;
    }

    public void setGradeIds(String gradeIds) {
        this.gradeIds = gradeIds;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
