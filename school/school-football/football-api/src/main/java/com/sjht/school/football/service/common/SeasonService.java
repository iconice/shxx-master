package com.sjht.school.football.service.common;

import com.sjht.school.football.resp.common.GetSeasonsByYearAndTermResp;

import java.util.List;

/**
 * ***************************************************
 * @ClassName SeasonService
 * @Description 赛程接口
 * @Author maojianyun
 * @Date 2019/10/10 14:12
 * @Version V1.0
 * ****************************************************
 **/
public interface SeasonService {

    /**
     * 根据学年和学期得到赛季
     * @return
     */
    List<GetSeasonsByYearAndTermResp> getSeasonsByYearAndTerm();
}
