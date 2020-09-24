package com.sjht.school.football.service.football.team;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.football.req.football.team.UpdatePlayersScoreReq;
import com.sjht.school.football.resp.football.team.GetPlayersListResp;
import com.sjht.school.football.resp.football.team.GetTeamUsersResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName TeamPlayersService
 * @Description 球队成员接口
 * @Author maojianyun
 * @Date 2019/9/10 9:33
 * @Version V1.0
 * ****************************************************
 **/
public interface TeamPlayersService {

    /**
     * 根据队id得到队员
     * @param teamId
     * @return
     */
    List<GetTeamUsersResp> getTeamUserByTeamId(String teamId, Integer category, String eventId, String studentName);

    /**
     * 到绑定球队的ids
     * @param teamId
     * @return
     */
    List<String> getBingTeamUserIds(String teamId);

    /**
     * 给球队添加球员
     * @param teamId
     * @param studentIdStr
     * @return
     */
    BaseResponse addTeamPlayers(String teamId, String studentIdStr);

    /**
     * 得到球队队员列表
     * @param teamId
     * @param type
     * @return
     */
    List<GetPlayersListResp> getPlayersList(String teamId, Integer type);

    /**
     * 跟新个人的分数
     * @param playersScoreReq
     * @return
     */
    BaseResponse updatePlayersScore(UpdatePlayersScoreReq playersScoreReq);

    /**
     * 判段选择队伍所在班级的学生已经被班级内的其他队伍选择的学生id列表
     * @param params
     * @return
     */
    List<String> getStudentIdsByOtherTeamChoose(Map<String, Object> params);
}
