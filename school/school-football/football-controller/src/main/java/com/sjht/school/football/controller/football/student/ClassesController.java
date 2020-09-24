package com.sjht.school.football.controller.football.student;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.ObjectResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.football.entity.SysUserEntity;
import com.sjht.school.football.entity.football.student.ClassEntity;
import com.sjht.school.football.req.football.student.AddClassReq;
import com.sjht.school.football.req.football.student.QueryClassPageReq;
import com.sjht.school.football.req.football.student.SubmitEditClassReq;
import com.sjht.school.football.resp.football.student.GetClassInfoResp;
import com.sjht.school.football.service.football.student.ClassService;
import com.sjht.school.football.service.football.student.GradeService;
import com.sjht.school.football.service.sys.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ***************************************************
 *
 * @ClassName ClassesController
 * @Description 班级接口控制层
 * @Author maojianyun
 * @Date 2019/9/5 10:19
 * @Version V1.0
 * ****************************************************
 **/
@Controller
@RequestMapping("/class")
public class ClassesController {

    @Autowired
    private ClassService classService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private GradeService gradeService;


    @RequestMapping("/toClassList")
    public String toClassList(Model model) {
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity user = (SysUserEntity)subject.getPrincipal();
        ObjectResponse gradeResps;
        gradeResps = gradeService.getgradeList(user.getId());
        model.addAttribute("grades", gradeResps.getData());
        return "football/classes/list";
    }

    @PostMapping("/queryClassPageList")
    @ResponseBody
    public PageResult queryClassPageList(QueryClassPageReq classPageReq) {
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity user = (SysUserEntity)subject.getPrincipal();
        classPageReq.setUserId(user.getId());
        return classService.queryClassPageList(classPageReq);
    }

    @PostMapping("/addClass")
    @ResponseBody
    public BaseResponse addClass(AddClassReq addClassReq) {
        return classService.addClass(addClassReq);
    }

    @GetMapping("/deleteClass")
    @ResponseBody
    public BaseResponse deleteClass(String classId) {
        return classService.deleteClass(classId);
    }

    /**
     * editPage
     * 去编辑页面
     * @param model
     * @return
     */
    @GetMapping("/edit")
    public String editPage(Model model, String classId) {
        GetClassInfoResp entity = classService.getClassInfo(classId);
        model.addAttribute("classInfo", entity);
        return "football/classes/classDetail";
    }

    @PostMapping("/submitEdit")
    @ResponseBody
    public BaseResponse submitEdit(SubmitEditClassReq editClassReq) {
        return classService.submitEdit(editClassReq);
    }

    /**
     * 得到年级班级列表
     * @return
     */
    @GetMapping("/getPeriodClass")
    @ResponseBody
    public BaseResponse getPeriodClass(){
        return classService.getPeriodClass();
    }

    /**
     * 修改用户得到班级信息
     * @return
     */
    @GetMapping("/getClassSelectList")
    @ResponseBody
    public BaseResponse getClassSelectList(String userId){
        return classService.getClassSelectList(userId);
    }
}
