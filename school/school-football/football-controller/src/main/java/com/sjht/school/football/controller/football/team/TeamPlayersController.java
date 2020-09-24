package com.sjht.school.football.controller.football.team;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.football.req.football.team.UpdatePlayersScoreReq;
import com.sjht.school.football.service.football.team.TeamPlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ***************************************************
 * @ClassName TeamPlayersController
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/9/10 9:40
 * @Version V1.0
 * ****************************************************
 **/
@Controller
@RequestMapping("teamPlayers")
public class TeamPlayersController {

    @Autowired
    private TeamPlayersService playersService;

    /**
     * 给球队添加成员
     * @param teamId
     * @param studentIdStr
     * @return
     */
    @PostMapping("/addTeamPlayers")
    @ResponseBody
    public BaseResponse addTeamPlayers(String teamId, String studentIdStr){
        return playersService.addTeamPlayers(teamId, studentIdStr);
    }

    @PostMapping("/updatePlayersScore")
    @ResponseBody
    public BaseResponse updatePlayersScore(UpdatePlayersScoreReq playersScoreReq){
        return playersService.updatePlayersScore(playersScoreReq);
    }

}
