package com.sjht.school.football.dao.football.team;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sjht.school.football.entity.football.team.TeamPlayersEntity;
import com.sjht.school.football.req.football.team.UpdatePlayersScoreReq;
import com.sjht.school.football.resp.football.team.GetPlayersListResp;
import com.sjht.school.football.resp.football.team.GetTeamUsersResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName TeamPlayersDao
 * @Description 球队成员数据层
 * @Author maojianyun
 * @Date 2019/9/10 9:34
 * @Version V1.0
 * ****************************************************
 **/
@Component
@Mapper
public interface TeamPlayersDao extends BaseMapper<TeamPlayersEntity> {

    /**
     * 根据队id得到队员列表
     * @param teamId
     * @return
     */
    List<GetTeamUsersResp> getTeamUserByTeamId(@Param("teamId") String teamId, @Param("eventId")String eventId, @Param("studentName")String studentName);

    List<GetTeamUsersResp> getCarnivalTeamUserByTeamId(@Param("teamId") String teamId, @Param("eventId")String eventId, @Param("studentName")String studentName);

    /**
     * 根据队id得到队员列表
     * @param teamId
     * @return
     */
    List<GetTeamUsersResp> getCarnivalTeamUserByTeamId(@Param("teamId") String teamId);

    /**
     * 查询加入球队的人数
     * @return
     */
    int getJoinTeamCount(@Param("teamId") String teamId);

    /**
     * 到绑定球队的ids
     * @param teamId
     * @return
     */
    List<String> getBingTeamUserIds(@Param("teamId") String teamId);

    /**
     * 判断学生是否加入到相同班级的其他队伍
     * @param teamId
     * @param studentId
     * @return
     */
    int getSetudentIsBingOtherClassTeam(@Param("teamId") String teamId, @Param("studentId") String studentId);

    /**
     * 得到球队队员列表
     * @param teamId
     * @return
     */
    List<GetPlayersListResp> getPlayersList(@Param("teamId") String teamId);

    List<GetPlayersListResp> getCarnivalPlayersList(@Param("teamId") String teamId);


    /**
     * 跟新分数
     * @param playersScoreReq
     * @return
     */
    int updatePlayersScore(@Param("ew")UpdatePlayersScoreReq playersScoreReq);

    /**
     * 判段选择队伍所在班级的学生已经被班级内的其他队伍选择的学生id列表（嘉年华或课堂）
     * @param params
     * @return
     */
    List<String> getJoinOtherTeamSIdChoose(@Param("params")Map<String, Object> params);

    /**
     * 判段选择队伍所在班级的学生已经被班级内的其他队伍选择的学生id列表(天天见)
     * @param gradeId
     * @param teamId
     * @return
     */
    List<String> getJoinOtherTeamSIdChooseDay(@Param("gradeId")String gradeId, @Param("teamId")String teamId);
}
