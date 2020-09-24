package com.sjht.school.football.service.football.team;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.football.req.football.event.EventInfoReq;
import com.sjht.school.football.req.football.team.*;
import com.sjht.school.football.resp.football.event.EventInfoResp;
import com.sjht.school.football.resp.football.team.QueryTeamPageResp;
import com.sjht.school.football.resp.football.team.TeamListResp;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 *
 * @ClassName TeamService
 * @Description 球队接口
 * @Author maojianyun
 * @Date 2019/9/10 9:07
 * @Version V1.0
 * ****************************************************
 **/
public interface TeamService {
    /**
     * 获得分页信息
     *
     * @param
     * @return
     */
    PageResult<QueryTeamPageResp> queryTeamPageList(QueryTeamPageReq queryTeamPageReq);

    /**
     * 得到球队列表
     *
     * @param params
     * @return
     */
    List<TeamListResp> getTeamList(Map<String, Object> params);

    /**
     * 添加球队
     *
     * @param addTeamReq
     * @return
     */

    BaseResponse addTeam(AddTeamReq addTeamReq);

    /**
     * 删除球队
     *
     * @param teamId
     * @return
     */
    BaseResponse deleteTeam(String teamId);

    /**
     * 删除球队成员
     *
     * @param deletePlayersReq
     * @return
     */
    BaseResponse deletePlayers(DeletePlayersReq deletePlayersReq);


    /**
     * 提交编辑
     *
     * @param submitEditTeamReq
     * @return
     */
    BaseResponse submitEditTeam(SubmitEditTeamReq submitEditTeamReq);


    /**
     * 删除球队所有成员
     *
     * @param deleteAllPlayersReq
     * @return
     */
    BaseResponse deleteAllPlayers(DeleteAllPlayersReq deleteAllPlayersReq);


    /**
     * 通过球队名称得到赛事信息
     *
     * @param teamId
     * @return
     */
    List<EventInfoResp> showEvent(String teamId);

    /**
     * 为胜利队伍增加积分
     *
     * @param teamId
     * @return
     */
    int win(String teamId);

    /**
     * 为平局队伍增加积分
     *
     * @param teamId
     * @return
     */
    int flat(String teamId);


}
