package com.sjht.school.football.controller.football.event;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.football.req.football.team.UpdatePlayersScoreReq;
import com.sjht.school.football.service.football.event.EventPlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ***************************************************
 * @ClassName EventPlayersController
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/9/29 15:17
 * @Version V1.0
 * ****************************************************
 **/
@Controller
@RequestMapping("eventPlayers")
public class EventPlayersController {

    @Autowired
    private EventPlayersService eventPlayersService;

    @PostMapping("/updatePlayersScore")
    @ResponseBody
    public BaseResponse updatePlayersScore(UpdatePlayersScoreReq playersScoreReq){
        return eventPlayersService.updatePlayersScore(playersScoreReq);
    }
}
