package com.sjht.school.football.controller.football.student;

import com.sjht.school.football.service.football.student.GradeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ***************************************************
 * @ClassName ClassUserController
 * @Description 班级用户关联控制层
 * @Author maojianyun
 * @Date 2019/9/20 14:56
 * @Version V1.0
 * ****************************************************
 **/
@Controller
@RequestMapping("classUser")
public class ClassUserController {

    @Autowired
    private GradeUserService classUserService;



}
