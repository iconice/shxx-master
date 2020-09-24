package com.sjht.school.football.service.impl.common;

import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sjht.school.common.utils.DateUtils;
import com.sjht.school.football.dao.common.SeasonDao;
import com.sjht.school.football.entity.common.SeasonEntity;
import com.sjht.school.football.resp.common.GetSeasonsByYearAndTermResp;
import com.sjht.school.football.service.common.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ***************************************************
 * @ClassName SeasonServiceImpl
 * @Description 赛程实现类
 * @Author maojianyun
 * @Date 2019/10/10 14:16
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class SeasonServiceImpl extends ServiceImpl<SeasonDao, SeasonEntity> implements IService<SeasonEntity>, SeasonService {

    @Autowired
    private SeasonDao seasonDao;

    @Override
    public List<GetSeasonsByYearAndTermResp> getSeasonsByYearAndTerm() {
        DateUtils dateUtils = DateUtils.getInstance();
        String year = dateUtils.getCurrentYearSemester(dateUtils.getCurrentYear(), dateUtils.getCurrentMonth(), dateUtils.YEAR);
        String term = dateUtils.getCurrentYearSemester(dateUtils.getCurrentYear(), dateUtils.getCurrentMonth(), dateUtils.SEMESTER);
        List<GetSeasonsByYearAndTermResp> result = seasonDao.getSeasonsByYearAndTerm(year, term);
        return result;
    }
}
