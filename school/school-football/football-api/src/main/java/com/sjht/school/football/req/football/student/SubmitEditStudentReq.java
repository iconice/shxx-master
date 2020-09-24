package com.sjht.school.football.req.football.student;

import java.io.Serializable;

/**
 * ***************************************************
 *
 * @ClassName SubmitEditStudentReq
 * @Description 描述
 * @Author 张弛
 * @Date 2019/9/6 17:27
 * @Version V1.0
 * ****************************************************
 **/
public class SubmitEditStudentReq implements Serializable {

    private String id;

    private String classId;

    private String name;

    private Integer age;

    private Integer sex;

    private Double height;

    private Double weight;

    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
