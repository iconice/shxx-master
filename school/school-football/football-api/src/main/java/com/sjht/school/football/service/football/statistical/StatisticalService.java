package com.sjht.school.football.service.football.statistical;

import com.baomidou.mybatisplus.plugins.Page;
import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.football.req.football.statistical.GetScoreboarListReq;
import com.sjht.school.football.req.football.statistical.GetTopScorerListReq;

/**
 * ***************************************************
 * @ClassName StatisticalService
 * @Description 统计接口
 * @Author maojianyun
 * @Date 2019/10/21 17:35
 * @Version V1.0
 * ****************************************************
 **/
public interface StatisticalService {

    /**
     * 得到射手榜列表
     * @param topScorerListReq
     * @return
     */
    PageResult getTopScorerList(GetTopScorerListReq topScorerListReq);

    /**
     * 得到节分列表
     * @param scoreboarListReq
     * @return
     */
    PageResult getScoreboardList(GetScoreboarListReq scoreboarListReq);
}
