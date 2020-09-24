package com.sjht.school.football.service.football.event;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.football.entity.football.event.EventPlayersEntity;
import com.sjht.school.football.req.football.team.UpdatePlayersScoreReq;

import java.util.List;

/**
 * ***************************************************
 * @ClassName EventPlayersService
 * @Description 赛事成员接口
 * @Author maojianyun
 * @Date 2019/9/29 8:18
 * @Version V1.0
 * ****************************************************
 **/
public interface EventPlayersService {

    /**
     * 批量加入
     * @param entities
     * @return
     */
    boolean batchInser(List<EventPlayersEntity> entities);

    /**
     * 删除参加赛事的人员
     * @param eventId
     * @return
     */
    boolean deleteByEventId(String eventId);

    /**
     * 更新分数
     * @param playersScoreReq
     * @return
     */
    BaseResponse updatePlayersScore(UpdatePlayersScoreReq playersScoreReq);

}
