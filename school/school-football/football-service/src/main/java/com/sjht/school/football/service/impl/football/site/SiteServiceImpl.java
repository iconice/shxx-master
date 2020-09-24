package com.sjht.school.football.service.impl.football.site;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.common.entity.ResultUtil;
import com.sjht.school.common.utils.IdUtil;
import com.sjht.school.common.utils.PageUtil;
import com.sjht.school.football.dao.football.site.SiteDao;
import com.sjht.school.football.entity.football.site.SiteEntity;
import com.sjht.school.football.req.football.site.AddSiteReq;
import com.sjht.school.football.req.football.site.SitePageListReq;
import com.sjht.school.football.req.football.site.SubmitEditSiteReq;
import com.sjht.school.football.resp.football.site.SiteInfoResp;
import com.sjht.school.football.resp.football.site.SitePageListResp;
import com.sjht.school.football.resp.football.student.QueryClassPageResp;
import com.sjht.school.football.service.football.site.SiteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName SiteServiceImpl
 * @Description 描述
 * @Author maojianyun
 * @Date 2019/9/5 23:30
 * @Version V1.0
 * ****************************************************
 **/
@Service
public class SiteServiceImpl extends ServiceImpl<SiteDao, SiteEntity> implements IService<SiteEntity>, SiteService {

    @Autowired
    private SiteDao siteDao;

    @Override
    public PageResult querySitePageList(SitePageListReq pageListReq) {
        PageResult pageResult = new PageResult();
        Map<String, Object> params = new HashMap<>();
        Integer pageNo = Integer.valueOf(PageUtil.getPageNo(pageListReq.getLimit(), pageListReq.getOffset()));
        Integer pageSize = Integer.valueOf(pageListReq.getLimit());
        Page<SitePageListResp> page = new Page<>(pageNo, pageSize);
        if(StringUtils.isNotBlank(pageListReq.getLocation())){
            params.put("location", pageListReq.getLocation());
        }
        if(StringUtils.isNotBlank(pageListReq.getSiteName())){
            params.put("siteName", pageListReq.getSiteName());
        }
        if(StringUtils.isNotBlank(pageListReq.getSiteType())){
            params.put("siteType", pageListReq.getSiteType());
        }
        List<SitePageListResp> datas = new ArrayList<>();
        long count = siteDao.querySitePageCount(params);
        if (count > 0) {
            datas.addAll(siteDao.querySitePageList(page, params));
        }
        return pageResult.resultPage(datas, count);
    }

    @Override
    public BaseResponse AddSite(AddSiteReq addSiteReq) {
        SiteEntity entity = new SiteEntity();
        entity.setId(IdUtil.getId());
        entity.setSiteName(addSiteReq.getSiteName());
        entity.setSiteType(addSiteReq.getSiteType());
        entity.setLocation(addSiteReq.getLocation());
        this.insert(entity);
        return ResultUtil.OK("添加成功");
    }

    @Override
    public BaseResponse deleteSite(String siteId) {
        this.deleteById(siteId);
        return ResultUtil.OK("删除成功");
    }

    @Override
    public SiteInfoResp getSiteInfo(String siteId) {
        SiteInfoResp infoResp = new SiteInfoResp();
        SiteEntity entity = this.selectById(siteId);
        infoResp.setSiteId(entity.getId());
        infoResp.setSiteName(entity.getSiteName());
        infoResp.setLocation(entity.getLocation());
        infoResp.setSiteType(entity.getSiteType());
        return infoResp;
    }

    @Override
    public BaseResponse submitEdit(SubmitEditSiteReq submitEditReq) {
        siteDao.updateSiteById(submitEditReq);
        return ResultUtil.OK("编辑成功");
    }

    @Override
    public List<SitePageListResp> getSiteList(String siteType) {
        return siteDao.getSiteList(siteType);
    }

    @Override
    public List<String> getSiteIdsByType(String type) {
        return siteDao.getSiteIdsByType(type);
    }
}
