package com.sjht.school.football.resp.football.student;

import java.io.Serializable;

/**
 * ***************************************************
 * @ClassName GetStudentListResp
 * @Description 得到学生列表
 * @Author maojianyun
 * @Date 2019/9/11 21:08
 * @Version V1.0
 * ****************************************************
 **/
public class GetStudentListResp implements Serializable {

    private String studentId;

    private String studentName;

    private String className;

    private Integer isSelect = 0;

    private Integer isOtherChoose = 0;

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

    public Integer getIsOtherChoose() {
        return isOtherChoose;
    }

    public void setIsOtherChoose(Integer isOtherChoose) {
        this.isOtherChoose = isOtherChoose;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
