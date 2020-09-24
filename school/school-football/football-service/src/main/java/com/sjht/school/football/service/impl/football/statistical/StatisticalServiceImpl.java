package com.sjht.school.football.service.impl.football.statistical;

import com.baomidou.mybatisplus.plugins.Page;
import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.common.utils.PageUtil;
import com.sjht.school.football.dao.football.student.StudentDao;
import com.sjht.school.football.dao.football.team.TeamDao;
import com.sjht.school.football.req.football.statistical.GetScoreboarListReq;
import com.sjht.school.football.req.football.statistical.GetTopScorerListReq;
import com.sjht.school.football.resp.football.statistical.GetScoreboarListResp;
import com.sjht.school.football.resp.football.statistical.GetTopScorerListResp;
import com.sjht.school.football.service.football.statistical.StatisticalService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName StatisticalServiceImpl
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/10/21 17:36
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class StatisticalServiceImpl implements StatisticalService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private TeamDao teamDao;

    @Override
    public PageResult getTopScorerList(GetTopScorerListReq topScorerListReq) {
        PageResult pageResult = new PageResult();
        Map<String, Object> params = new HashMap<>();
        Integer pageNo = Integer.valueOf(PageUtil.getPageNo(topScorerListReq.getLimit(), topScorerListReq.getOffset()));
        Integer pageSize = Integer.valueOf(topScorerListReq.getLimit());
        Page<GetTopScorerListResp> page = new Page<>(pageNo, pageSize);
        if(StringUtils.isNotBlank(topScorerListReq.getGradeId())){
            params.put("gradeId", topScorerListReq.getGradeId());
        }
        if(StringUtils.isNotBlank(topScorerListReq.getClassId())){
            params.put("classId", topScorerListReq.getClassId());
        }

        params.put("teamType", topScorerListReq.getTeamType());

        long count = 0;
                List<GetTopScorerListResp> datas = new ArrayList<>();
        if (topScorerListReq.getTeamType() == 1) {
            count = studentDao.getDayTopScorerListCount(params);
            if (count > 0) {
                datas.addAll(studentDao.getDayTopScorerList(page, params));
            }
        } else {
            count = studentDao.getClassRoomTopScorerListCount(params);
            if (count > 0) {
                datas.addAll(studentDao.getClassRoomTopScorerList(page, params));
            }
        }
        return pageResult.resultPage(datas, count);
    }

    @Override
    public PageResult getScoreboardList(GetScoreboarListReq scoreboarListReq) {
        PageResult pageResult = new PageResult();
        Map<String, Object> params = new HashMap<>();
        Integer pageNo = Integer.valueOf(PageUtil.getPageNo(scoreboarListReq.getLimit(), scoreboarListReq.getOffset()));
        Integer pageSize = Integer.valueOf(scoreboarListReq.getLimit());
        Page<GetScoreboarListResp> page = new Page<>(pageNo, pageSize);
        if(StringUtils.isNotBlank(scoreboarListReq.getGradeId())){
            params.put("gradeId", scoreboarListReq.getGradeId());
        }
        if(StringUtils.isNotBlank(scoreboarListReq.getClassId())){
            params.put("classId", scoreboarListReq.getClassId());
        }
        long count = 0;
        List<GetScoreboarListResp> datas = new ArrayList<>();
        if (scoreboarListReq.getTeamType() == 1) {
            count = teamDao.getDayScoreboardListCount(params);
            if (count > 0) {
                datas.addAll(teamDao.getDayScoreboardList(page, params));
            }
        } else {
            count = teamDao.getClassRoomScoreboardListCount(params);
            if (count > 0) {
                datas.addAll(teamDao.getClassRoomScoreboardList(page, params));
            }
        }
        return pageResult.resultPage(datas, count);
    }
}
