package com.sjht.school.football.resp.sys;

/**
 * ***************************************************
 * @ClassName TeacherListResp
 * @Description 老师响应
 * @Author maojianyun
 * @Date 2019/9/5 13:47
 * @Version V1.0
 * ****************************************************
 **/
public class TeacherListResp {

    private String userId;

    private String name;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
