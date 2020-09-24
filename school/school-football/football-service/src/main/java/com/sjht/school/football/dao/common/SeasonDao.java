package com.sjht.school.football.dao.common;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sjht.school.football.entity.common.SeasonEntity;
import com.sjht.school.football.resp.common.GetSeasonsByYearAndTermResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ***************************************************
 * @ClassName SeasonDao
 * @Description 赛程数据层
 * @Author maojianyun
 * @Date 2019/10/10 14:13
 * @Version V1.0
 * ****************************************************
 **/
@Component
@Mapper
public interface SeasonDao extends BaseMapper<SeasonEntity> {

    /**
     * 根据学年和学期得到赛季
     * @param year 学年
     * @param term 学期
     * @return
     */
    List<GetSeasonsByYearAndTermResp> getSeasonsByYearAndTerm(@Param("year") String year, @Param("term") String term);
}
