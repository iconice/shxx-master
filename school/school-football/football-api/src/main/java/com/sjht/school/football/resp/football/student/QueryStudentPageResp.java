package com.sjht.school.football.resp.football.student;

import java.io.Serializable;

/**
 * ***************************************************
 *
 * @ClassName QueryStudentPageResp
 * @Description 分页查询学生响应
 * @Author zhangchi
 * @Date 2019/9/5 22:48
 * @Version V1.0
 * ****************************************************
 **/
public class QueryStudentPageResp implements Serializable {

    private String studentId; //学生ID

    private String gradeId;

    private String className;

    private String name;//学生姓名

    private Integer age;

    private Boolean sex;

    private Double height;

    private Double weight;

    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }
}