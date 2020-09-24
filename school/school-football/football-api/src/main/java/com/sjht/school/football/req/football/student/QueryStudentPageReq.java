package com.sjht.school.football.req.football.student;

import com.sjht.school.common.entity.PageBase;

/**
 * ***************************************************
 *
 * @ClassName QueryStudentPageReq
 * @Description 描述
 * @Author 张弛
 * @Date 2019/9/5 22:24
 * @Version V1.0
 * ****************************************************
 **/
public class QueryStudentPageReq extends PageBase {

    private String gradeId;

    private String classId;

    private String sex;

    private String name;//学生姓名

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
