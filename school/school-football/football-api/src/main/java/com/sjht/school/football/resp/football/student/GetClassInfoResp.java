package com.sjht.school.football.resp.football.student;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName GetClassInfoResp
 * @Description 得到班级信息
 * @Author maojianyun
 * @Date 2019/9/23 13:40
 * @Version V1.0
 * ****************************************************
 **/
public class GetClassInfoResp implements Serializable {

    private String id;

    private String className;

    private String leaderName;

    private String gradeName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }
}
