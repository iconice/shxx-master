package com.sjht.school.football.service.football.site;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.football.req.football.site.AddSiteReq;
import com.sjht.school.football.req.football.site.SitePageListReq;
import com.sjht.school.football.req.football.site.SubmitEditSiteReq;
import com.sjht.school.football.resp.football.site.SiteInfoResp;
import com.sjht.school.football.resp.football.site.SitePageListResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ***************************************************
 * @ClassName SiteService
 * @Description 场地接口
 * @Author maojianyun
 * @Date 2019/9/5 23:27
 * @Version V1.0
 * ****************************************************
 **/
public interface SiteService {

    /**
     * 场地分页查询
     * @param pageListReq
     * @return
     */
    PageResult querySitePageList(SitePageListReq pageListReq);

    /**
     * 添加
     * @param addSiteReq
     * @return
     */
    BaseResponse AddSite(AddSiteReq addSiteReq);

    /**
     * 删除场地
     * @param siteId
     * @return
     */
    BaseResponse deleteSite(String siteId);

    /**
     * 得到场地信息
     * @param siteId
     * @return
     */
    SiteInfoResp getSiteInfo(String siteId);

    /**
     * 提交编辑
     * @param submitEditReq
     * @return
     */
    BaseResponse submitEdit(SubmitEditSiteReq submitEditReq);

    /**
     * 得到场地列表
     * @param siteType
     * @return
     */
    List<SitePageListResp> getSiteList(String siteType);

    /**
     * 得到场地ids
     * @param type
     * @return
     */
    List<String> getSiteIdsByType(String type);
}
