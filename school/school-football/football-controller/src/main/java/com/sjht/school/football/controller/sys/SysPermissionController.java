package com.sjht.school.football.controller.sys;

import com.sjht.school.common.constant.CoreConst;
import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.football.entity.PermissionEntity;
import com.sjht.school.football.entity.SysUserEntity;
import com.sjht.school.football.req.sys.AddPermissionReq;
import com.sjht.school.football.resp.sys.GetAllMenuResp;
import com.sjht.school.football.resp.sys.QueryPermissionListResp;
import com.sjht.school.football.service.sys.SysPermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("sys/permission")
public class SysPermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 去资源列表页面
     * @return
     */
    @GetMapping("/permissionsPage")
    public String permissionList(){
        return "permission/list";
    }

    /**
     * 得到菜单列表
     * @return
     */
    @PostMapping("getMenuListByUserId")
    @ResponseBody
    public BaseResponse getMenuListByUserId(){
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity sysUserEntity = (SysUserEntity)subject.getPrincipal();
        BaseResponse baseResponse = sysPermissionService.getMenuListByUserId(sysUserEntity.getId());
        return baseResponse;
    }

    @PostMapping("queryPermissionList")
    @ResponseBody
    public List<QueryPermissionListResp> queryPermissionList(String flage) {
        return sysPermissionService.queryPermissionList(flage);
    }

    @PostMapping("getAllMenu")
    @ResponseBody
    public List<GetAllMenuResp> getAllMenu(String flag){
        return sysPermissionService.getAllMenu();
    }

    @PostMapping("AddPermission")
    @ResponseBody
    public BaseResponse AddPermission(AddPermissionReq addPermissionReq){
        return sysPermissionService.AddPermission(addPermissionReq);
    }

    @PostMapping("deletPermission")
    @ResponseBody
    public BaseResponse deletPermission(String id){
        return sysPermissionService.deletPermission(id);
    }

    /**
     * 去编辑页面
     * @return
     */
    @GetMapping("/edit")
    public String edit(Model model, String permissionId){
        PermissionEntity permission = sysPermissionService.getPermissionInfo(permissionId);
        if(null!=permission){
            if(permission.getParentId().equals(CoreConst.TOP_MENU_ID)){
                model.addAttribute("parentName", CoreConst.TOP_MENU_NAME);
            }else{
                PermissionEntity parent = sysPermissionService.getPermissionInfo(permission.getParentId());
                model.addAttribute("parentName", parent.getName());
            }
        }
        model.addAttribute("permission", permission);
        return "permission/detail";
    }

    @ResponseBody
    @PostMapping("/submitEdit")
    public BaseResponse editPermission(PermissionEntity permission){
        return sysPermissionService.editPermission(permission);
    }

}
