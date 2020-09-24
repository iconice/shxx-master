package com.sjht.school.football.service.impl.football.event;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sjht.school.common.Link.FootbalList;
import com.sjht.school.common.Link.algorithm.*;
import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.ObjectResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.common.entity.ResultUtil;
import com.sjht.school.common.utils.DateUtils;
import com.sjht.school.common.utils.IdUtil;
import com.sjht.school.common.utils.PageUtil;
import com.sjht.school.football.dao.football.event.EventDao;
import com.sjht.school.football.dao.football.team.TeamDao;
import com.sjht.school.football.entity.football.event.EventEntity;
import com.sjht.school.football.entity.football.event.EventPlayersEntity;
import com.sjht.school.football.req.football.event.AutoCreateEventReq;
import com.sjht.school.football.req.football.event.EditeEventReq;
import com.sjht.school.football.req.football.event.ManualCreateEventReq;
import com.sjht.school.football.req.football.event.QueryEventPageListReq;
import com.sjht.school.football.resp.football.event.AddScoreResp;
import com.sjht.school.football.resp.football.event.QueryEventPageListResp;
import com.sjht.school.football.resp.football.team.GetPlayersListResp;
import com.sjht.school.football.resp.football.team.TeamListResp;
import com.sjht.school.football.service.football.event.EventPlayersService;
import com.sjht.school.football.service.football.event.EventService;
import com.sjht.school.football.service.football.team.TeamPlayersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 *
 * @ClassName EventServiceImpl
 * @Description 赛事接口实现类
 * @Author maojianyun
 * @Date 2019/9/10 9:57
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class EventServiceImpl extends ServiceImpl<EventDao, EventEntity> implements IService<EventEntity>, EventService {

    @Autowired
    private EventDao eventDao;

    @Autowired
    private TeamDao teamDao;

    @Autowired
    private EventPlayersService eventPlayersService;

    @Autowired
    private TeamPlayersService playersService;


    @Override
    public PageResult queryEventPageList(QueryEventPageListReq eventPageListReq) {
        PageResult pageResult = new PageResult();
        Map<String, Object> params = new HashMap<>();
        List<QueryEventPageListResp> datas = new ArrayList<>();
        Integer pageNo = Integer.valueOf(PageUtil.getPageNo(eventPageListReq.getLimit(), eventPageListReq.getOffset()));
        Integer pageSize = Integer.valueOf(eventPageListReq.getLimit());
        Page<QueryEventPageListResp> page = new Page<>(pageNo, pageSize);
        if (StringUtils.isNotBlank(eventPageListReq.getUserId())) {
            params.put("userId", eventPageListReq.getUserId());
        }
        if (StringUtils.isNotBlank(eventPageListReq.getEventName())) {
            params.put("eventName", eventPageListReq.getEventName());
        }
        if (StringUtils.isNotBlank(eventPageListReq.getTeamName())) {
            params.put("teamName", eventPageListReq.getTeamName());
        }
        if (null != eventPageListReq.getStartTime()) {
            params.put("startTime", eventPageListReq.getStartTime());
        }
        if (null != eventPageListReq.getEndTime()) {
            params.put("endTime", eventPageListReq.getEndTime());
        }
        if (0 != eventPageListReq.getBatchNo()) {
            params.put("batchNO", eventPageListReq.getBatchNo());
        }
        params.put("type", eventPageListReq.getType());
        params.put("category", eventPageListReq.getCategory());
        long count = 0;
        if (1 == eventPageListReq.getCategory()) {
            count = eventDao.queryDayEventPageCount(params);
            if (count > 0) {
                datas.addAll(eventDao.queryDayEventPageList(page, params));
            }
        } else if (2 == eventPageListReq.getCategory()) {
            count = eventDao.queryCarnivalEventPageCount(params);
            if (count > 0) {
                datas.addAll(eventDao.queryCarnivalEventPageList(page, params));
            }
        } else if (3 == eventPageListReq.getCategory()) {
            count = eventDao.queryClassroomEventPageCount(params);
            if (count > 0) {
                datas.addAll(eventDao.queryClassroomEventPageList(page, params));
            }
        }
        return pageResult.resultPage(datas, count);
    }

    @Transactional
    @Override
    public BaseResponse deleteEventByEvenId(String eventId) {
        BaseResponse baseResponse = new ObjectResponse<>();
        // 删除赛事
        this.deleteById(eventId);
        // 删除赛事得成员
        boolean b = eventPlayersService.deleteByEventId(eventId);
        // 删除赛事参加人
        return ((ObjectResponse) baseResponse).OK("删除成功");
    }

    @Override
    public BaseResponse manualCreateEvent(AutoCreateEventReq createEventReq) {
        EventEntity entity = new EventEntity();
        // 0.判断是否选了同一个队伍
        if (createEventReq.getTeam1Id().equals(createEventReq.getTeam2Id())) {
            return ResultUtil.error("选择了两个相同的球队了");
        }
        // 4.插入赛事
        entity.setId(IdUtil.getId());
        entity.setEventName(createEventReq.getEventName());
        entity.setType(createEventReq.getType());
        entity.setGradeId(createEventReq.getGradeId());
        entity.setClassId(createEventReq.getClassId());
        entity.setSiteId(createEventReq.getSiteId());
        entity.setTeam1Id(createEventReq.getTeam1Id());
        entity.setTeam2Id(createEventReq.getTeam2Id());
        entity.setStartTime(createEventReq.getStartTime());
        entity.setEndTime(createEventReq.getEndTime());
        this.insert(entity);
        return ResultUtil.OK("创建成功");
    }

    @Override
    public EventEntity getEventInfo(String eventId) {
        return this.selectById(eventId);
    }

    @Override
    public BaseResponse updateScore(AddScoreResp addScoreResp) {
        eventDao.updateScore(addScoreResp);
        return ResultUtil.OK("操作成功");
    }

    @Transactional
    @Override
    public BaseResponse createEvent(ManualCreateEventReq createEventReq) {
        List<EventEntity> datas = new ArrayList<>();
        // 插入赛事
        EventEntity entity = new EventEntity();
        String id = IdUtil.getId();
        entity.setId(id);
        entity.setSeasonId(createEventReq.getSeasonId());
        entity.setCategory(createEventReq.getCategory());
        entity.setBatchNo(createEventReq.getBatchNo());
        entity.setTeam2Id(createEventReq.getTeam2Id());
        entity.setTeam1Id(createEventReq.getTeam1Id());
        entity.setType(createEventReq.getType());
        entity.setSiteId(createEventReq.getSiteId());
        entity.setGradeId(createEventReq.getGradeId());
        entity.setClassId(createEventReq.getClassId());
        // 插入赛事的成员
        addEventPlayers(entity, entity.getCategory());

        this.insert(entity);
        return ResultUtil.OK("操作成功");
    }

    @Transactional
    @Override
    public BaseResponse autoCreateEvent(AutoCreateEventReq createEventReq) throws Exception {
        List<BuildEvent> events = new ArrayList<>();
        // 查询出队伍
        Map<String, Object> params = new HashMap<>();
        List<TeamListResp> dataList = new ArrayList<>();
        params.put("category", createEventReq.getCategory());
        params.put("seasonId", createEventReq.getSeasonId());
        if (1 == createEventReq.getCategory()) {
            params.put("gradeId", createEventReq.getGradeId());
            dataList.addAll(teamDao.getDayeamList(params));
        }
        if (2 == createEventReq.getCategory()) {
            params.put("gradeId", createEventReq.getGradeId());
            dataList.addAll(teamDao.getCarnivalTeamList(params));
        }
        if (3 == createEventReq.getCategory()) {
            params.put("classId", createEventReq.getClassId());
            dataList.addAll(teamDao.getClassroomTeamList(params));
        }
        int count = eventDao.evetIsEnd(params);
        if (count == 0) {
            if (this.seasonAlreadyCreate(params)) {
                return ResultUtil.error("该赛季已经比赛过了");
            }
            List<EventEntity> entitys = new ArrayList<>();
            if (dataList != null && dataList.size() > 1) {
                events.addAll(this.eventList(dataList, createEventReq.getSiteIds()));
                for (BuildEvent buildEvent : events) {
                    EventEntity entity = new EventEntity();
                    entity.setId(IdUtil.getId());
                    entity.setGradeId(createEventReq.getGradeId());
                    if (createEventReq.getCategory() == 3) {
                        entity.setClassId(createEventReq.getClassId());
                    }
                    entity.setSiteId(buildEvent.getSiteId());
                    entity.setType(createEventReq.getType());
                    entity.setTeam1Id(buildEvent.getTeam1Id());
                    entity.setTeam2Id(buildEvent.getTeam2Id());
                    entity.setBatchNo(buildEvent.getBatchNo());
                    entity.setCategory(createEventReq.getCategory());
                    entity.setSeasonId(createEventReq.getSeasonId());
                    entitys.add(entity);
                }
                if (entitys.size() > 0) {
                    addEventPlayers(entitys, createEventReq);
                    // 添加赛事
                    this.insertBatch(entitys);
                }
            } else {
                return ResultUtil.error("该班级或该届的没有球队或球队只有1只");
            }
        } else {
            return ResultUtil.error("该班级或该届还有赛事没有完成");
        }
        return ResultUtil.OK();
    }

    /**
     * 判断该赛季是否已经创建赛事
     *
     * @param params
     * @return
     */
    public boolean seasonAlreadyCreate(Map<String, Object> params) {
        DateUtils dateUtils = DateUtils.getInstance();
        params.put("year", dateUtils.getCurrentYearSemester(dateUtils.getCurrentYear(), dateUtils.getCurrentMonth(), dateUtils.YEAR));
        params.put("term", dateUtils.getCurrentYearSemester(dateUtils.getCurrentYear(), dateUtils.getCurrentMonth(), dateUtils.SEMESTER));
        List<String> ids = eventDao.seasonAlreadyCreate(params);
        return ids.size() > 0 ? true : false;
    }

    public void addEventPlayers(List<EventEntity> entitys, AutoCreateEventReq createEventReq) {
        // 给赛事添加成员
        // 此处患处啊查询有待改进 目前先这样写
        List<EventService> eventServices = new ArrayList<>();
        List<EventPlayersEntity> entities = new ArrayList<>();
        for (EventEntity entity : entitys) {
            // 查询team1的队员
            List<GetPlayersListResp> playersList1 = playersService.getPlayersList(entity.getTeam1Id(), createEventReq.getCategory());
            for (GetPlayersListResp resp : playersList1) {
                EventPlayersEntity playersEntity = new EventPlayersEntity();
                playersEntity.setId(IdUtil.getId());
                playersEntity.setEventId(entity.getId());
                playersEntity.setTeamId(entity.getTeam1Id());
                playersEntity.setStudentId(resp.getStudentId());
                entities.add(playersEntity);
            }
            // 查询team2的队员
            List<GetPlayersListResp> playersList2 = playersService.getPlayersList(entity.getTeam2Id(), createEventReq.getCategory());
            for (GetPlayersListResp resp : playersList2) {
                EventPlayersEntity playersEntity = new EventPlayersEntity();
                playersEntity.setId(IdUtil.getId());
                playersEntity.setEventId(entity.getId());
                playersEntity.setTeamId(entity.getTeam2Id());
                playersEntity.setStudentId(resp.getStudentId());
                entities.add(playersEntity);
            }

        }
        // 构造赛事成员
        eventPlayersService.batchInser(entities);
    }

    public void addEventPlayers(EventEntity entity, Integer category) {
        // 给赛事添加成员
        // 此处患处啊查询有待改进 目前先这样写
        List<EventService> eventServices = new ArrayList<>();
        List<EventPlayersEntity> entities = new ArrayList<>();

        // 查询team1的队员
        List<GetPlayersListResp> playersList1 = playersService.getPlayersList(entity.getTeam1Id(), category);
        for (GetPlayersListResp resp : playersList1) {
            EventPlayersEntity playersEntity = new EventPlayersEntity();
            playersEntity.setId(IdUtil.getId());
            playersEntity.setEventId(entity.getId());
            playersEntity.setTeamId(entity.getTeam1Id());
            playersEntity.setStudentId(resp.getStudentId());
            entities.add(playersEntity);
        }
        // 查询team2的队员
        List<GetPlayersListResp> playersList2 = playersService.getPlayersList(entity.getTeam2Id(), category);
        for (GetPlayersListResp resp : playersList2) {
            EventPlayersEntity playersEntity = new EventPlayersEntity();
            playersEntity.setId(IdUtil.getId());
            playersEntity.setEventId(entity.getId());
            playersEntity.setTeamId(entity.getTeam2Id());
            playersEntity.setStudentId(resp.getStudentId());
            entities.add(playersEntity);
        }
        // 构造赛事成员
        eventPlayersService.batchInser(entities);
    }

    public List<BuildEvent> eventList(List<TeamListResp> dataList, List<String> siteIds) throws Exception {
        List<BuildEvent> eventNodes = new ArrayList<>();
        FootbalList teamLinkList1 = new FootballLinkList();
        FootbalList teamLinkList2 = new FootballLinkList();
        FootbalList siteLinkList1 = new FootballLinkList();
        int teamSize = dataList.size();
        if ((teamSize & 1) != 0) {// 如果队伍个数为奇数 则节点加一个空的队伍
            dataList.add(new TeamListResp());
            teamSize = teamSize + 1;
        }
        // 队列1
        for (int i = 0; i < teamSize / 2; i++) {
            TeamListResp resp = dataList.get(i);
            teamLinkList1.insertTail(resp.getTeamId());
        }
        // 队列2
        for (int i = teamSize / 2; i < teamSize; i++) {
            TeamListResp resp = dataList.get(i);
            teamLinkList2.insertHead(resp.getTeamId());
        }
        FootballNode next1 = ((FootballLinkList) teamLinkList1).getHead().getNext();
        FootballNode next2 = ((FootballLinkList) teamLinkList2).getHead().getNext();
        for (int i = 0; i < teamSize - 1; i++) {
            for (int k = 0; k < siteIds.size(); k++) {
                siteLinkList1.insertHead(siteIds.get(k));
            }
            BuildEvent(teamSize / 2, eventNodes, next1, next2, i + 1, siteLinkList1);
            if (teamSize == 2) {
                break;
            }
            // 删除2的第一个元素
            FootballNode node2 = teamLinkList2.delete(1);
            // 把删除的元素插入到1的第一个位置
            teamLinkList1.insert(2, node2.getElement());
            // 删除第1的尾部元素
            FootballNode node1 = teamLinkList1.deleteTail();
            // 把尾部元素添加到第2的尾部
            teamLinkList2.insertTail(node1.getElement());
            next1 = ((FootballLinkList) teamLinkList1).getHead().getNext();
            next2 = ((FootballLinkList) teamLinkList2).getHead().getNext();
        }
        return eventNodes;
    }

    public void BuildEvent(int size, List<BuildEvent> eventNodes, FootballNode teamList1, FootballNode teamList2, int batchNo, FootbalList siteLinkList1) {
        for (int i = 0; i < size; i++) {
            BuildEvent buildEvent = new BuildEvent();
            if (teamList1 != null) {
                buildEvent.setTeam1Id(teamList1.getElement() + "");
                teamList1 = teamList1.getNext();
            }

            if (teamList2 != null) {
                buildEvent.setTeam2Id(teamList2.getElement() + "");
                teamList2 = teamList2.getNext();
            }

            FootballNode siteNode = siteLinkList1.deleteHead();
            if (siteNode != null) {
                buildEvent.setSiteId(siteNode.getElement() + "");
            }
            buildEvent.setBatchNo(batchNo);
            eventNodes.add(buildEvent);
        }
    }

    @Override
    public BaseResponse endEvent(String eventId) {
        eventDao.updateStatus(eventId);
        return ResultUtil.OK("更新成功");
    }

    @Override
    public BaseResponse submitEditeEvent(EditeEventReq editeEventReq) {
        eventDao.submitEditeEvent(editeEventReq);
        return ResultUtil.OK("更新成功");
    }

    @Override
    public BaseResponse showTodayCountEvent() {
        eventDao.showTodayEventCount();
        return ResultUtil.OK("查询成功");
    }

//    @Override
//    public BaseResponse showTodayEvent() {
//        eventDao.showTodayEvent();
//        return ResultUtil.OK("查询成功");
//    }


    @Override
    public List<EventEntity> showTodayEvent() {

        return eventDao.showTodayEvent();
    }
}
