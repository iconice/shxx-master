package com.sjht.school.football.controller.football.team;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.ObjectResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.football.entity.SysUserEntity;
import com.sjht.school.football.req.football.team.*;
import com.sjht.school.football.resp.football.event.EventInfoResp;
import com.sjht.school.football.resp.football.student.GetClassListResp;
import com.sjht.school.football.resp.football.team.TeamListResp;
import com.sjht.school.football.service.football.event.EventService;
import com.sjht.school.football.service.football.student.ClassService;
import com.sjht.school.football.service.football.student.GradeService;
import com.sjht.school.football.service.football.team.TeamService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 *
 * @ClassName TeamController
 * @Description 球队控制类
 * @Author maojianyun
 * @Date 2019/9/10 9:11
 * @Version V1.0
 * ****************************************************
 **/
@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private ClassService classService;

    @Autowired
    private GradeService gradeService;

    /**
     * 跳转到球队列表页面
     *
     * @return
     */
    @RequestMapping("/teamList")
    public String queryTeamList(Model model) {
        Map<String, Object> params = new HashMap<>();
        // 查询班级
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity user = (SysUserEntity) subject.getPrincipal();
        ObjectResponse gradeResps = gradeService.getgradeList(user.getId());
        model.addAttribute("grades", gradeResps.getData());
        return "football/team/list";
    }

    /**
     * 查询学生列表页面
     *
     * @return
     */
    @PostMapping("/queryTeamPageList")
    @ResponseBody
    public PageResult queryTeamPageList(QueryTeamPageReq queryTeamPageReq) {
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity sysUserEntity = (SysUserEntity)subject.getPrincipal();
        queryTeamPageReq.setUserId(sysUserEntity.getId());
        return teamService.queryTeamPageList(queryTeamPageReq);
    }

    /**
     * 添加学生
     *
     * @param addTeamReq
     * @return
     */
    @PostMapping("/addTeam")
    @ResponseBody
    public BaseResponse addTeam(AddTeamReq addTeamReq) {
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity sysUserEntity = (SysUserEntity)subject.getPrincipal();
        addTeamReq.setUserId(sysUserEntity.getId());
        return teamService.addTeam(addTeamReq);
    }

    /*
     * 删除球队
     *
     * */
    @GetMapping("/deleteTeam")
    @ResponseBody
    public BaseResponse deleteTeam(String teamId) {

        //teamService
        return teamService.deleteTeam(teamId);
    }

    /*
     * 删除球队成员
     *
     * */
    @GetMapping("/deletePlayers")
    @ResponseBody
    public BaseResponse deletePlayers(DeletePlayersReq deletePlayersReq) {
        return teamService.deletePlayers(deletePlayersReq);
    }

    /*
     * 删除球队中所有成员
     *
     * */
    @GetMapping("/deleteAllPlayers")
    @ResponseBody
    public BaseResponse deleteAllPlayers(DeleteAllPlayersReq deleteAllPlayersReq) {
        return teamService.deleteAllPlayers(deleteAllPlayersReq);
    }

    /*
     * 球队详情
     *
     * */
    @GetMapping("/edit")
    public String edit(Model model, String studentId) {
        return "football/team/teamDetail";
    }

    /*
    *
    * 编辑提交学生
    * */
    @PostMapping("/submitEditTeam")
    @ResponseBody
    public BaseResponse submitEditTeam(SubmitEditTeamReq editTeamReq) {
        return teamService.submitEditTeam(editTeamReq);
    }

    @GetMapping("/toAddTeamUserPage")
    public String toAddTeamUserPage(String teamId){
        return "football/team/playerslist";
    }

    @GetMapping("getTeamListByClassIdORGrade")
    @ResponseBody
    public List<TeamListResp> getTeamListByClassIdORGrade(String classId, String gradeId, String category){
        Map<String, Object> params = new HashMap<>();
        params.put("classId", classId);
        params.put("gradeId", gradeId);
        params.put("category", category);
        List<TeamListResp> result = teamService.getTeamList(params);
        return result;
    }

    @PostMapping("getTeamOtherList")
    @ResponseBody
    public Map<String, Object> getTeamOtherList(String team1Id, String gradeId, String classId, Integer type){
        Map<String, Object> params = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        params.put("classId", classId);
        params.put("gradeId", gradeId);
        params.put("team1Id", team1Id);
        params.put("type", type);
        List<TeamListResp> rows = teamService.getTeamList(params);
        result.put("rows", rows);
        return result;
    }

    /**
     * 新增球队
     * @return
     */
    @GetMapping("addTeamDetail")
    public String addTeamDetail(Model model){
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity user = (SysUserEntity)subject.getPrincipal();
        ObjectResponse gradeResps;
        gradeResps = gradeService.getgradeList(user.getId());
        model.addAttribute("grades", gradeResps.getData());
        return "football/team/addTeamDetail";
    }

    @GetMapping("getClassList")
    @ResponseBody
    public List<GetClassListResp> getClassList(String gradeId){
        Map<String, Object> params = new HashMap<>();
        // 查询班级
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity sysUserEntity = (SysUserEntity) subject.getPrincipal();
        List<GetClassListResp> classList = new ArrayList<>();
        params.put("gradeId", gradeId);
        return classService.getClassList(params);
    }

    /**
     * 添加球员详情页面
     * @param model
     * @param type
     * @return
     */
    @GetMapping("addTeamPlayersDetail/{teamId}/{type}/{count}/{gradeId}")
    public String addTeamPlayersDetail(Model model, @PathVariable String teamId, @PathVariable Integer type, @PathVariable Integer count, @PathVariable String gradeId){
        List<String> periodList = new ArrayList<>();
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity sysUserEntity = (SysUserEntity)subject.getPrincipal();
        model.addAttribute("teamId", teamId);
        model.addAttribute("type", type);
        model.addAttribute("count", count);
        model.addAttribute("gradeId", gradeId);
        return "football/team/addTeamPlayersDetail";
    }

    /**
     * 显示球队赛程信息
     * @param model
     * @param
     * @return
     */
    @GetMapping("/showEvent")
    public String showEvent(Model model, String  teamId){
        // List<EventInfoResp> info = teamService.showEvent(teamId);
        model.addAttribute("teamId", teamId);
        return "football/team/showEventDetail";
    }

    /**
     * 显示球队球员信息
     * @param model
     * @param team1Id
     * @return
     */
    @GetMapping("/showPlayer")
    public String showPlayer(Model model, String team1Id){
        return "football/team/showPlayerDetail";
    }
}
