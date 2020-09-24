package com.sjht.school.football.controller.football.statistical;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.ObjectResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.football.entity.SysUserEntity;
import com.sjht.school.football.req.football.statistical.GetScoreboarListReq;
import com.sjht.school.football.req.football.statistical.GetTopScorerListReq;
import com.sjht.school.football.service.football.statistical.StatisticalService;
import com.sjht.school.football.service.football.student.GradeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName StatisticalController
 * @Description 数据统计控制器
 * @Author maojianyun
 * @Date 2019/10/21 17:29
 * @Version V1.0
 * ****************************************************
 **/
@Controller
@RequestMapping("statistical")
public class StatisticalController {

    @Autowired
    private GradeService gradeService;

    @Autowired
    private StatisticalService statisticalService;


    /**
     * 去射手榜页面
     * @return
     */
    @GetMapping("event/topScorer")
    public String toTopScorerList(Model model){
        Map<String, Object> params = new HashMap<>();
        // 查询班级
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity user = (SysUserEntity) subject.getPrincipal();
        ObjectResponse gradeResps = gradeService.getgradeList(user.getId());
        model.addAttribute("grades", gradeResps.getData());
        return "football/statistical/topScorerList";
    }

    /**
     * 得到射手榜列表
     * @param topScorerListReq
     * @return
     */
    @PostMapping("event/getTopScorerList")
    @ResponseBody
    public PageResult getTopScorerList(GetTopScorerListReq topScorerListReq){
        return statisticalService.getTopScorerList(topScorerListReq);
    }

    /**
     * 去射手榜页面
     * @return
     */
    @GetMapping("event/toScoreboard")
    public String toScoreboard(Model model){
        Map<String, Object> params = new HashMap<>();
        // 查询班级
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity user = (SysUserEntity) subject.getPrincipal();
        ObjectResponse gradeResps = gradeService.getgradeList(user.getId());
        model.addAttribute("grades", gradeResps.getData());
        return "football/statistical/scoreboardList";
    }

    /**
     * 得到积分榜列表
     * @param scoreboarListReq
     * @return
     */
    @PostMapping("event/getScoreboardList")
    @ResponseBody
    public PageResult getScoreboardList(GetScoreboarListReq scoreboarListReq){
        return statisticalService.getScoreboardList(scoreboarListReq);
    }
}

