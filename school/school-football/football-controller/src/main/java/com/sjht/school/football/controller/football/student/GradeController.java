package com.sjht.school.football.controller.football.student;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.football.entity.SysUserEntity;
import com.sjht.school.football.service.football.student.GradeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/gradeList")
    @ResponseBody
    public BaseResponse getgradeList(){
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity user = (SysUserEntity)subject.getPrincipal();
        return gradeService.getgradeList(user.getId());
    }

    @GetMapping("/getUserGradeList")
    @ResponseBody
    public BaseResponse getUserGradeList(String userId){
        return gradeService.getUserGradeList(userId);
    }


}
