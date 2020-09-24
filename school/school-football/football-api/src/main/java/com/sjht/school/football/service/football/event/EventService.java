package com.sjht.school.football.service.football.event;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.football.entity.football.event.EventEntity;
import com.sjht.school.football.req.football.event.AutoCreateEventReq;
import com.sjht.school.football.req.football.event.EditeEventReq;
import com.sjht.school.football.req.football.event.ManualCreateEventReq;
import com.sjht.school.football.req.football.event.QueryEventPageListReq;
import com.sjht.school.football.resp.football.event.AddScoreResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ***************************************************
 * @ClassName EventService
 * @Description 赛事接口
 * @Author maojianyun
 * @Date 2019/9/10 9:53
 * @Version V1.0
 * ****************************************************
 **/
public interface EventService {

    /**
     * 赛事分页查询
     * @param eventPageListReq
     * @return
     */
    PageResult queryEventPageList(QueryEventPageListReq eventPageListReq);

    /**
     * 删除赛事
     * @param eventId
     * @return
     */
    BaseResponse deleteEventByEvenId(String eventId);

    /**
     * 创建赛事
     * @param createEventReq
     * @return
     */
    BaseResponse manualCreateEvent(AutoCreateEventReq createEventReq);

    /**
     * 得到用户信息
     * @param eventId
     * @return
     */
    EventEntity getEventInfo(String eventId);

    /**
     * 添加比分
     * @param addScoreResp
     * @return
     */
    BaseResponse updateScore(@Param("ew")AddScoreResp addScoreResp);

    /**
     * 创建赛事
     * @param createEventReq
     * @return
     */
    BaseResponse createEvent(ManualCreateEventReq createEventReq);

    /**
     * 自动阻塞
     * @param createEventReq
     * @return
     */
    BaseResponse autoCreateEvent(AutoCreateEventReq createEventReq) throws Exception;

    /**
     * 结束赛事
     * @param eventId
     * @return
     */
    BaseResponse endEvent(String eventId);

    /**
     * 提交编辑
     * @param editeEventReq
     * @return
     */
    BaseResponse submitEditeEvent(EditeEventReq editeEventReq);

    /**
     * 查看今天的赛事总数
     * @param
     * @return
     */
    BaseResponse showTodayCountEvent();

    /**
     * 查看今天的赛事
     * @param
     * @return
     */
    List<EventEntity> showTodayEvent();
}
