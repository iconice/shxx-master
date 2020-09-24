package com.sjht.school.football.dao.football.team;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sjht.school.football.entity.football.team.TeamEntity;
import com.sjht.school.football.req.football.team.DeleteAllPlayersReq;
import com.sjht.school.football.req.football.team.DeletePlayersReq;
import com.sjht.school.football.req.football.team.SubmitEditTeamReq;
import com.sjht.school.football.resp.football.team.QueryTeamPageResp;
import com.sjht.school.football.resp.football.team.TeamListResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName TeamDao
 * @Description 球队数据层
 * @Author maojianyun
 * @Date 2019/9/10 9:08
 * @Version V1.0
 * ****************************************************
 **/
@Component
@Mapper
public interface TeamDao extends BaseMapper<TeamEntity> {

    /**
     * 球队分页查询数量
     * @param params
     * @return
     */
    long queryTeamPageCount(@Param("params") Map<String, Object> params);

    /**
     * 天天见分页查询数量
     * @param params
     * @return
     */
    long queryTeamDayPageCount(@Param("params") Map<String, Object> params);

    /**
     * 球队分页查询列表
     * @param page
     * @param params
     * @return
     */
    List<QueryTeamPageResp> queryTeamPageList(Page<QueryTeamPageResp> page, @Param("params") Map<String, Object> params);

    /**
     * 天天见分页查询列表
     * @param page
     * @param params
     * @return
     */
    List<QueryTeamPageResp> queryTeamDayPageList(Page<QueryTeamPageResp> page, @Param("params") Map<String, Object> params);

    /**
     * 得到球队列表
     * @param params
     * @return
     */
    List<TeamListResp> getTeamList(@Param("params") Map<String, Object> params);

    /**
     * 课堂联赛队伍
     * @param params
     * @return
     */
    List<TeamListResp> getClassroomTeamList(@Param("params") Map<String, Object> params);

    /**
     * 嘉年华联赛队伍
     * @param params
     * @return
     */
    List<TeamListResp> getCarnivalTeamList(@Param("params") Map<String, Object> params);

    /**
     * 天天乐联赛队伍
     * @param params
     * @return
     */
    List<TeamListResp> getDayeamList(@Param("params") Map<String, Object> params);


    /**
     * 提交编辑
     * @param editTeamReq
     * @return
     */
    int updateByTeamId(@Param("ew") SubmitEditTeamReq editTeamReq);

    /*删除球队成员*/
    int deletePlayers(@Param("dp")DeletePlayersReq deletePlayersReq);

    /**
     * 查询该队伍在本班级内的其他队伍已经组建了赛事的队伍id
     * @param params
     * @return
     */
    List<String> getEventTeamIdByTeamId(@Param("params")Map<String, Object> params);

    /*一键删除球队成员*/
    int deleteAllPlayers(@Param("dp") DeleteAllPlayersReq deleteAllPlayersReq);

    /**
     * 为获胜球队加分
     * @param
     * @return
     */
    int win(@Param("teamId") String teamId);

    /**
     * 为平局球队加分
     * @param
     * @return
     */
    int flat(@Param("teamId") String teamId);
}
