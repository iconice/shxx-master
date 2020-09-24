package com.sjht.school.football.dao.football.site;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.sjht.school.football.entity.football.site.SiteEntity;
import com.sjht.school.football.req.football.site.SubmitEditSiteReq;
import com.sjht.school.football.resp.football.site.SitePageListResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * ***************************************************
 * @ClassName SiteDao
 * @Description 场地数据层
 * @Author maojianyun
 * @Date 2019/9/5 23:29
 * @Version V1.0
 * ****************************************************
 **/
@Component
@Mapper
public interface SiteDao extends BaseMapper<SiteEntity> {

    /**
     * 分页查询列表
     * @param page
     * @param params
     * @return
     */
    List<SitePageListResp> querySitePageList(Page<SitePageListResp> page, @Param("params")Map<String, Object> params);

    /**
     * 分页查询数量
     * @param params
     * @return
     */
    long querySitePageCount( @Param("params")Map<String, Object> params);

    /**
     * 场地的提交编辑
     * @param editReq
     * @return
     */
    int updateSiteById(@Param("ew") SubmitEditSiteReq editReq);

    /**
     * 得到场地列表
     * @param siteType
     * @return
     */
    List<SitePageListResp> getSiteList(@Param("siteType")String siteType);

    /**
     * 得到场地id列表
    * @param type
     * @return
     */
    List<String> getSiteIdsByType(@Param("type")String type);
}
