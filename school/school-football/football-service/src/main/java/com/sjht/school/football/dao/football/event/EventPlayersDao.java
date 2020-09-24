package com.sjht.school.football.dao.football.event;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sjht.school.football.entity.football.event.EventPlayersEntity;
import com.sjht.school.football.req.football.team.UpdatePlayersScoreReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * ***************************************************
 * @ClassName EventPlayersDao
 * @Description 赛事成员列表
 * @Author maojianyun
 * @Date 2019/9/29 8:19
 * @Version V1.0
 * ****************************************************
 **/
@Component
@Mapper
public interface EventPlayersDao extends BaseMapper<EventPlayersEntity> {

    /**
     * 跟新分数
     * @param playersScoreReq
     * @return
     */
    int updatePlayersScore(@Param("ew")UpdatePlayersScoreReq playersScoreReq);
}
