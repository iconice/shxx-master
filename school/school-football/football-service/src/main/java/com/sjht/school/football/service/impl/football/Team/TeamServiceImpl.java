package com.sjht.school.football.service.impl.football.Team;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.common.entity.ResultUtil;
import com.sjht.school.common.utils.IdUtil;
import com.sjht.school.common.utils.PageUtil;
import com.sjht.school.football.dao.football.event.EventDao;
import com.sjht.school.football.dao.football.team.TeamDao;
import com.sjht.school.football.dao.football.team.TeamPlayersDao;
import com.sjht.school.football.entity.football.team.TeamEntity;
import com.sjht.school.football.req.football.event.EventInfoReq;
import com.sjht.school.football.req.football.team.*;

import com.sjht.school.football.resp.football.event.EventInfoResp;
import com.sjht.school.football.resp.football.team.QueryTeamPageResp;
import com.sjht.school.football.resp.football.team.TeamListResp;
import com.sjht.school.football.service.football.team.TeamService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 *
 * @ClassName TeamServiceImpl
 * @Description 球队服务实现类
 * @Author maojianyun
 * @Date 2019/9/10 9:09
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class TeamServiceImpl extends ServiceImpl<TeamDao, TeamEntity> implements IService<TeamEntity>, TeamService {

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private TeamPlayersDao teamPlayersDao;

    @Autowired
    private EventDao eventDao;

    /*
     * 分页结果信息    *
     * */
    @Override
    public PageResult<QueryTeamPageResp> queryTeamPageList(QueryTeamPageReq queryTeamPageReq) {
        Map<String, Object> params = new HashMap<>();
        PageResult<QueryTeamPageResp> pageResult = new PageResult<>();
        Integer pageNo = Integer.valueOf(PageUtil.getPageNo(queryTeamPageReq.getLimit(), queryTeamPageReq.getOffset()));
        Integer pageSize = Integer.valueOf(queryTeamPageReq.getLimit());
        Page<QueryTeamPageResp> page = new Page<>(pageNo, pageSize);
        List<QueryTeamPageResp> datas = new ArrayList<>();
        if (StringUtils.isNotBlank(queryTeamPageReq.getTeamName())) {
            params.put("teamName", queryTeamPageReq.getTeamName());
        }
        if (StringUtils.isNotBlank(queryTeamPageReq.getTeamType())) {
            params.put("teamType", queryTeamPageReq.getTeamType());
        }
        if (StringUtils.isNotBlank(queryTeamPageReq.getClassId())) {
            params.put("classId", queryTeamPageReq.getClassId());
        }
        if (StringUtils.isNotBlank(queryTeamPageReq.getGradeId())) {
            params.put("gradeId", queryTeamPageReq.getGradeId());
        }
        if (StringUtils.isNotBlank(queryTeamPageReq.getGradeId())) {
            params.put("userId", queryTeamPageReq.getUserId());
        }
        long count = 0;
        if ("1".equals(queryTeamPageReq.getTeamType())) {
            count = teamDao.queryTeamDayPageCount(params);
            if (count > 0) {
                List<QueryTeamPageResp> datalist = teamDao.queryTeamDayPageList(page, params);
                for (QueryTeamPageResp pageResp : datalist) {
                    pageResp.setJoinCount(teamPlayersDao.getJoinTeamCount(pageResp.getTeamId()));
                }
                datas.addAll(datalist);
            }
        } else {
            count = teamDao.queryTeamPageCount(params);
            if (count > 0) {
                List<QueryTeamPageResp> datalist = teamDao.queryTeamPageList(page, params);
                for (QueryTeamPageResp pageResp : datalist) {
                    pageResp.setJoinCount(teamPlayersDao.getJoinTeamCount(pageResp.getTeamId()));
                }
                datas.addAll(datalist);
            }
        }

        return pageResult.resultPage(datas, count);
    }

    @Override
    public List<TeamListResp> getTeamList(Map<String, Object> params) {
        List<TeamListResp> listResps = new ArrayList<>();
        Integer category = Integer.valueOf(params.get("category").toString());
        if (category == 1) { // 天天见
            listResps.addAll(teamDao.getDayeamList(params));
        } else {
            listResps.addAll(teamDao.getClassroomTeamList(params));
        }
        return listResps;
    }

    @Override
    public BaseResponse addTeam(AddTeamReq addTeamReq) {
        TeamEntity teamEntity = new TeamEntity();
        teamEntity.setId(IdUtil.getId());
        teamEntity.setUserId(addTeamReq.getUserId());
        teamEntity.setTeamName(addTeamReq.getTeamName());
        teamEntity.setCount(addTeamReq.getCount());
        teamEntity.setTeamType(addTeamReq.getTeamType());
        teamEntity.setGradeId(addTeamReq.getGradeId());
        teamEntity.setClassId(addTeamReq.getClassId());
        this.insert(teamEntity);
        return ResultUtil.OK("添加成功");

    }

    @Override
    public BaseResponse deleteTeam(String teamId) {
        this.deleteById(teamId);
        return ResultUtil.OK("删除成功");
    }

    /* 删除球队成员*/
    @Override
    public BaseResponse deletePlayers(DeletePlayersReq deletePlayersReq) {
        teamDao.deletePlayers(deletePlayersReq);
        return ResultUtil.OK("删除成功");
    }

    /*删除球队中的所有成员*/
    @Override
    public BaseResponse deleteAllPlayers(DeleteAllPlayersReq deleteAllPlayersReq) {
        teamDao.deleteAllPlayers(deleteAllPlayersReq);
        return ResultUtil.OK("删除成功");
    }

    @Override
    public BaseResponse submitEditTeam(SubmitEditTeamReq submitEditTeamReq) {
        teamDao.updateByTeamId(submitEditTeamReq);
        return ResultUtil.OK("编辑成功");
    }

    @Override
    public List<EventInfoResp> showEvent(String teamId) {
        return eventDao.showEvent(teamId);
    }

    @Override
    public int win(String teamId) {
        return  teamDao.win(teamId);
    }

    @Override
    public int flat(String teamId) {
        return  teamDao.flat(teamId);
    }
}
