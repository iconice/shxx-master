package com.sjht.school.football.service.impl.football.Team;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.ResultUtil;
import com.sjht.school.common.utils.IdUtil;
import com.sjht.school.football.dao.football.team.TeamPlayersDao;
import com.sjht.school.football.entity.football.team.TeamPlayersEntity;
import com.sjht.school.football.req.football.team.UpdatePlayersScoreReq;
import com.sjht.school.football.resp.football.team.GetPlayersListResp;
import com.sjht.school.football.resp.football.team.GetTeamUsersResp;
import com.sjht.school.football.service.football.team.TeamPlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName TeamPlayersServiceImpl
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/9/10 9:43
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class TeamPlayersServiceImpl extends ServiceImpl<TeamPlayersDao, TeamPlayersEntity> implements IService<TeamPlayersEntity>, TeamPlayersService {

    @Autowired
    private TeamPlayersDao teamPlayersDao;

    @Override
    public List<GetTeamUsersResp> getTeamUserByTeamId(String teamId, Integer category, String eventId, String studentName) {
        if (2 == category) {
            return teamPlayersDao.getCarnivalTeamUserByTeamId(teamId, eventId, studentName);
        }
        return teamPlayersDao.getTeamUserByTeamId(teamId, eventId, studentName);
    }

    @Override
    public List<String> getBingTeamUserIds(String teamId) {
        return teamPlayersDao.getBingTeamUserIds(teamId);
    }

    @Transactional
    @Override
    public BaseResponse addTeamPlayers(String teamId, String studentIdStr) {
        List<TeamPlayersEntity> entities = new ArrayList<>();
        Wrapper<TeamPlayersEntity> wrapper = new EntityWrapper<>();
        wrapper.where("team_id={0}", teamId);
        String[] ids = studentIdStr.split(",");
        for (String studentId: ids) {
            // 判断该学生是否已经加入该班级的其他球队
//            if (teamPlayersDao.getSetudentIsBingOtherClassTeam(teamId, studentId) > 0) {
//                return ResultUtil.error("学生：" + studentId + "已经加入班级其他的队");
//            }
            TeamPlayersEntity entity = new TeamPlayersEntity();
            entity.setId(IdUtil.getId());
            entity.setTeamId(teamId);
            entity.setStudentId(studentId);
            entities.add(entity);
            try {
                Thread.sleep(100);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        // this.delete(wrapper);
        this.insertBatch(entities);
        return ResultUtil.OK("添加成功");
    }

    @Override
    public List<GetPlayersListResp> getPlayersList(String teamId,Integer category) {
        if (2 == category){
            return teamPlayersDao.getCarnivalPlayersList(teamId);
        }
        return teamPlayersDao.getPlayersList(teamId);
    }

    @Override
    public BaseResponse updatePlayersScore(UpdatePlayersScoreReq playersScoreReq) {
        if (playersScoreReq.getOperation().equals("+")) {
            playersScoreReq.setScore(1);
        } else {
            playersScoreReq.setScore(-1);
        }
        teamPlayersDao.updatePlayersScore(playersScoreReq);
        return ResultUtil.OK("操作成功");
    }

    @Override
    public List<String> getStudentIdsByOtherTeamChoose(Map<String, Object> params) {

        Integer type = params.get("type") != null? Integer.valueOf(params.get("type").toString()): null;
        String teamId = params.get("teamId").toString();
        String gradeId = params.get("gradeId") != null? params.get("gradeId").toString(): null;
        if (type == 1) {
            return teamPlayersDao.getJoinOtherTeamSIdChooseDay(gradeId, teamId);
        }
        return teamPlayersDao.getJoinOtherTeamSIdChoose(params);
    }
}
