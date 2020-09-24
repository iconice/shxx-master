package com.sjht.school.football.controller.football.site;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.football.req.football.site.AddSiteReq;
import com.sjht.school.football.req.football.site.SitePageListReq;
import com.sjht.school.football.req.football.site.SubmitEditSiteReq;
import com.sjht.school.football.resp.football.site.SiteInfoResp;
import com.sjht.school.football.service.football.site.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ***************************************************
 * @ClassName SiteController
 * @Description 场地控制器
 * @Author maojianyun
 * @Date 2019/9/6 20:39
 * @Version V1.0
 * ****************************************************
 **/
@Controller
@RequestMapping("/site")
public class SiteController {

    @Autowired
    private SiteService siteService;

    @GetMapping("/siteList")
    public String toSiteList(){
        return "football/site/list";
    }

    @PostMapping("/querySitePageList")
    @ResponseBody
    public PageResult querySitePageList(SitePageListReq pageListReq){
        return siteService.querySitePageList(pageListReq);
    }

    @PostMapping("/AddSite")
    @ResponseBody
    public BaseResponse AddSite(AddSiteReq addSiteReq){
        return siteService.AddSite(addSiteReq);
    }

    @GetMapping("/deleteSite")
    @ResponseBody
    public BaseResponse deleteSite(String siteId){
        return siteService.deleteSite(siteId);
    }

    /**
     * 去编辑页面
     * @param model
     * @param siteId
     * @return
     */
    @GetMapping("/edit")
    public String edit(Model model, String siteId){
        SiteInfoResp info = siteService.getSiteInfo(siteId);
        model.addAttribute("siteInfo", info);
        return "football/site/siteDetail";
    }

    @PostMapping("/submitEdit")
    @ResponseBody
    public BaseResponse submitEdit(SubmitEditSiteReq submitEditReq){
        return siteService.submitEdit(submitEditReq);
    }



}
