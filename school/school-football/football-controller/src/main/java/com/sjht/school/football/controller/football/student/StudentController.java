package com.sjht.school.football.controller.football.student;


import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.ObjectResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.football.entity.SysUserEntity;
import com.sjht.school.football.entity.football.student.StudentEntity;
import com.sjht.school.football.req.football.student.AddStudentReq;
import com.sjht.school.football.req.football.student.QueryStudentPageReq;
import com.sjht.school.football.req.football.student.SubmitEditStudentReq;
import com.sjht.school.football.resp.football.student.GetClassListResp;
import com.sjht.school.football.resp.football.student.GetStudentListResp;
import com.sjht.school.football.resp.football.team.GetPlayersListResp;
import com.sjht.school.football.service.football.student.ClassService;
import com.sjht.school.football.service.football.student.GradeService;
import com.sjht.school.football.service.football.student.StudentService;
import com.sjht.school.football.service.football.team.TeamPlayersService;
import com.sjht.school.football.shiro.LonginUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * ***************************************************
 *
 * @ClassName StudentController
 * @Description 学生接口控制层
 * @Author zhangchi
 * @Date 2019/9/5 22:19
 * @Version V1.0
 * ****************************************************
 **/
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassService classService;

    @Autowired
    private TeamPlayersService playersService;

    @Autowired
    private GradeService gradeService;

    /**
     * 跳转到学生列表页面
     * @return
     */
    @GetMapping("/studentList")
    public String queryGradeList(Model model) {
        Map<String, Object> params = new HashMap<>();
        // 查询班级
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity user = (SysUserEntity) subject.getPrincipal();
        ObjectResponse gradeResps = gradeService.getgradeList(user.getId());
        params.put("userId", user.getId());
        model.addAttribute("grades", gradeResps.getData());
        return "football/student/list";
    }

    /**
     * 查询学生列表页面
     *
     * @return
     */
    @PostMapping("/queryStudentPageList")
    @ResponseBody
    public PageResult queryStudentPageList(QueryStudentPageReq queryStudentPageReq) {
        return studentService.queryStudentPageList(queryStudentPageReq);
    }

    /**
     * 添加学生
     *
     * @param addStudentReq
     * @return
     */
    @PostMapping("/addStudent")
    @ResponseBody
    public BaseResponse addStudent(AddStudentReq addStudentReq) {
        return studentService.addStudent(addStudentReq);
    }

    @GetMapping("/deleteStudent")
    @ResponseBody
    public BaseResponse deleteStudent(String studentId) {
        return studentService.deleteStudent(studentId);
    }

    @GetMapping("/edit")
    public String edit(Model model, String studentId, String gradeId) {
        Map<String, Object> params = new HashMap<>();
        // 查询班级
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity sysUserEntity = (SysUserEntity) subject.getPrincipal();
        List<GetClassListResp> classList = new ArrayList<>();
        StudentEntity entity = studentService.studentInfo(studentId);
        params.put("gradeId", gradeId);
        model.addAttribute("classes", classService.getClassList(params));
        model.addAttribute("student", entity);
        return "football/student/studentDetail";
    }

    @PostMapping("/submitEditStudent")
    @ResponseBody
    public BaseResponse submitEditStudent(SubmitEditStudentReq editStudentReq) {
        return studentService.submitEditStudent(editStudentReq);
    }

    @PostMapping("/getStudentList")
    @ResponseBody
    public Map<String, Object> getStudentList(String teamId, String sex, Integer type, String gradeId, String classId, String studentName) {
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> datas = new HashMap<>();
        List<GetStudentListResp> listData = new ArrayList<>();
        params.put("teamId", teamId);
        params.put("sex", sex);
        params.put("type", type);
        params.put("gradeId", gradeId);
        params.put("classId", classId);
        params.put("studentName", studentName);

        List<GetStudentListResp> list = studentService.getStudentList(params);
        List<String> hasIds = playersService.getBingTeamUserIds(teamId);
        List<String> otherHasIds = playersService.getStudentIdsByOtherTeamChoose(params);
        // 已经选了的人
        for (GetStudentListResp listResp : list) {
            for (String hasId : hasIds) {
                if (hasId.equals(listResp.getStudentId())) {
                    listResp.setIsSelect(1);
                    break;
                }
            }
            listData.add(listResp);
        }
        // 删除已经被其他队选择的学生
        Iterator<GetStudentListResp> result = listData.iterator();
        while (result.hasNext()) {
            GetStudentListResp student = result.next();
            for (String otherId : otherHasIds) {
                if (otherId.equals(student.getStudentId())) {
                    result.remove();
                    break;
                }
            }
        }
        datas.put("rows", listData);
        datas.put("hasIds", hasIds);
        return datas;
    }

    @PostMapping("/getPlayersList")
    @ResponseBody
    public Map<String, Object> getPlayersList(String teamId, Integer type) {
        Map<String, Object> datas = new HashMap<>();
        List<GetPlayersListResp> list = playersService.getPlayersList(teamId, type);
        datas.put("rows", list);
        return datas;
    }
}