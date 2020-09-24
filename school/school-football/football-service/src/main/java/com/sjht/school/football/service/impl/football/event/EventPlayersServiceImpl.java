package com.sjht.school.football.service.impl.football.event;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.ResultUtil;
import com.sjht.school.football.dao.football.event.EventDao;
import com.sjht.school.football.dao.football.event.EventPlayersDao;
import com.sjht.school.football.dao.football.student.StudentDao;
import com.sjht.school.football.dao.football.team.TeamPlayersDao;
import com.sjht.school.football.entity.football.event.EventPlayersEntity;
import com.sjht.school.football.req.football.team.UpdatePlayersScoreReq;
import com.sjht.school.football.service.football.event.EventPlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * ***************************************************
 * @ClassName EventPlayersServiceImpl
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/9/29 8:22
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class EventPlayersServiceImpl extends ServiceImpl<EventPlayersDao, EventPlayersEntity> implements IService<EventPlayersEntity>, EventPlayersService {

    @Autowired
    private EventPlayersDao eventPlayersDao;

    @Autowired
    private EventDao eventDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeamPlayersDao teamPlayersDao;

    @Override
    public boolean batchInser(List<EventPlayersEntity> entities) {
        return this.insertBatch(entities);
    }

    @Override
    public boolean deleteByEventId(String eventId) {
        Wrapper wrapper = new EntityWrapper();
        wrapper.where("event_id={0}", eventId);
        return this.delete(wrapper);
    }

    @Transactional
    @Override
    public BaseResponse updatePlayersScore(UpdatePlayersScoreReq playersScoreReq) {
        if (playersScoreReq.getOperation().equals("+")) {
            playersScoreReq.setScore(1);
        } else {
            playersScoreReq.setScore(-1);
        }
        if (playersScoreReq.getTeam() == 1) {
            eventDao.updateEventTeam1score(playersScoreReq);
        } else {
            eventDao.updateEventTeam2score(playersScoreReq);
        }
        studentDao.updateStudentScore(playersScoreReq);
        teamPlayersDao.updatePlayersScore(playersScoreReq);
        eventPlayersDao.updatePlayersScore(playersScoreReq);
        return ResultUtil.OK("操作成功");
    }
}
