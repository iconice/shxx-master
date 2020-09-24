package com.sjht.school.football.controller.football.event;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.ObjectResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.football.entity.SysUserEntity;
import com.sjht.school.football.entity.football.event.EventEntity;
import com.sjht.school.football.req.football.event.EditeEventReq;
import com.sjht.school.football.req.football.event.AutoCreateEventReq;
import com.sjht.school.football.req.football.event.ManualCreateEventReq;
import com.sjht.school.football.req.football.event.QueryEventPageListReq;
import com.sjht.school.football.resp.football.event.AddScoreResp;
import com.sjht.school.football.resp.football.site.SitePageListResp;
import com.sjht.school.football.resp.football.student.GetClassListResp;
import com.sjht.school.football.resp.football.student.GradeResp;
import com.sjht.school.football.resp.football.team.GetTeamUsersResp;
import com.sjht.school.football.service.common.SeasonService;
import com.sjht.school.football.service.football.event.EventService;
import com.sjht.school.football.service.football.site.SiteService;
import com.sjht.school.football.service.football.student.ClassService;
import com.sjht.school.football.service.football.student.GradeService;
import com.sjht.school.football.service.football.team.TeamPlayersService;
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
 * @ClassName EventController
 * @Description 赛事控制层
 * @Author maojianyun
 * @Date 2019/9/10 9:54
 * @Version V1.0
 * ****************************************************
 **/
@Controller
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private SiteService siteService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamPlayersService playersService;

    @Autowired
    private ClassService classService;

    @Autowired
    private GradeService gradeService;

    @Autowired
    private SeasonService seasonService;


    /**
     * 去赛事页面
     * @param model
     * @return
     */
    @GetMapping("/eventList")
    public String toEventPage(Model model){
        return "football/event/list";
    }

    /**
     * 赛事分页列表
     * @param eventPageListReq
     * @return
     */
    @PostMapping("/queryEventPageList")
    @ResponseBody
    public PageResult queryEventPageList(QueryEventPageListReq eventPageListReq){
        // 查询班级
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity sysUserEntity = (SysUserEntity)subject.getPrincipal();
        eventPageListReq.setUserId(sysUserEntity.getId());
        return eventService.queryEventPageList(eventPageListReq);
    }

    /**
     * 删除赛事
     * @param eventId
     * @return
     */
    @GetMapping("/deleteEventByEvenId")
    @ResponseBody
    public BaseResponse deleteEventByEvenId(String eventId){
        return eventService.deleteEventByEvenId(eventId);
    }

    /**
     * 手动创建赛事页面
     * @param model
     * @return
     */
    @GetMapping("/toManualCreateEventPage")
    public String toManualCreateEventPage(Model model){
        Map<String, Object> params = new HashMap<>();
        // 场地
        List<SitePageListResp> siteList = siteService.getSiteList(null);
        // 查询战队
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity sysUserEntity = (SysUserEntity)subject.getPrincipal();
        ObjectResponse grades = gradeService.getgradeList(sysUserEntity.getId());
        List<GradeResp> gradeList = (List<GradeResp>) grades.getData();
        params.put("gradeId", gradeList.size() > 0? gradeList.get(0).getGradeId():null);
        List<GetClassListResp> classes =  classService.getClassList(params);
        model.addAttribute("grades", gradeList);
        model.addAttribute("seasons", seasonService.getSeasonsByYearAndTerm());
        model.addAttribute("siteList", siteList);
        return "football/event/manualCreateEvent";
    }

    /**
     * 手动创建赛事页面
     * @param model
     * @return
     */
    @GetMapping("/toAutoCreateEventPage")
    public String toAutoCreateEventPage(Model model){
        Map<String, Object> params = new HashMap<>();
        // 届列表
        List<String> periodList = new ArrayList<>();
        // 班级列表
        List<GetClassListResp> classList = new ArrayList<>();
        // 查询战队
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity sysUserEntity = (SysUserEntity)subject.getPrincipal();
        String userId = null;
        ObjectResponse grades = gradeService.getgradeList(sysUserEntity.getId());
        List<GradeResp> gradeList = (List<GradeResp>) grades.getData();
        params.put("gradeId", gradeList.size() > 0? gradeList.get(0).getGradeId():null);
        List<GetClassListResp> classes =  classService.getClassList(params);
        model.addAttribute("grades", gradeList);
        model.addAttribute("classes", classes);
        model.addAttribute("seasons", seasonService.getSeasonsByYearAndTerm());
        // model.addAttribute("siteList", siteList);
        return "football/event/outoCreateEvent";
    }

    /**
     * 手动创建赛事
     * @param createEventReq
     * @return
     */
    @PostMapping("/manualCreateEvent")
    @ResponseBody
    public BaseResponse manualCreateEvent(AutoCreateEventReq createEventReq){
        // 查询班级
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity sysUserEntity = (SysUserEntity)subject.getPrincipal();
        return eventService.manualCreateEvent(createEventReq);
    }

    @GetMapping("addScorePage")
    public String addScorePage(Model model, String eventId, Integer category){
        model.addAttribute("eventInfo", eventService.getEventInfo(eventId));
        model.addAttribute("category", category);
        return "football/event/addScore";
    }

    @PostMapping("getTeamUserByTeamId")
    @ResponseBody
    public Map<String, Object> getTeamUserByTeamId(String teamId, Integer category, String eventId, String studentName) {
        List<GetTeamUsersResp> roleList = playersService.getTeamUserByTeamId(teamId, category, eventId, studentName);
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("rows", roleList);
        return jsonMap;
    }

    @PostMapping("updateScore")
    @ResponseBody
    public BaseResponse updateScore(AddScoreResp addScoreResp) {
        return eventService.updateScore(addScoreResp);
    }

    /**
     * 创建赛事
     * @param createEventReq
     * @return
     */
    @PostMapping("createEvent")
    @ResponseBody
    public BaseResponse createEvent(ManualCreateEventReq createEventReq){
        return eventService.createEvent(createEventReq);
    }

    /**
     * 自动创建赛事
     * @param createEventReq
     * @returnoutoCreateEvent.html
     */
    @PostMapping("autoCreateEvent")
    @ResponseBody
    public BaseResponse autoCreateEvent(AutoCreateEventReq createEventReq)throws Exception{
        createEventReq.setSiteIds(siteService.getSiteIdsByType(createEventReq.getType()+""));
        return eventService.autoCreateEvent(createEventReq);
    }

    @GetMapping("editeEventdetail/{eventId}/{status}")
    public String editeEventdetail(Model model,@PathVariable String eventId, @PathVariable Integer status){
        // 查询场地
        List<SitePageListResp> siteList = siteService.getSiteList(null);
        // 查询详情
        EventEntity entity = eventService.getEventInfo(eventId);
        model.addAttribute("siteList", siteList);
        model.addAttribute("entityInfo", entity);
        return "football/event/editeEventdetail";
    }

    @GetMapping("endEvent")
    @ResponseBody
    public BaseResponse endEvent(String eventId){
        return  eventService.endEvent(eventId);
    }

    @PostMapping("submitEditeEvent")
    @ResponseBody
    public BaseResponse submitEditeEvent(EditeEventReq editeEventReq){
        return eventService.submitEditeEvent(editeEventReq);
    }

}
