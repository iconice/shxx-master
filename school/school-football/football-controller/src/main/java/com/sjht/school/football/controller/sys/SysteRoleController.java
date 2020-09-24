package com.sjht.school.football.controller.sys;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.football.entity.PermissionEntity;
import com.sjht.school.football.entity.SysRoleEntity;
import com.sjht.school.football.req.sys.AddRoleReq;
import com.sjht.school.football.req.sys.LoginUserReq;
import com.sjht.school.football.req.sys.QueryRolePageReq;
import com.sjht.school.football.resp.sys.PermissionTreeListResp;
import com.sjht.school.football.resp.sys.QueryPermissionListResp;
import com.sjht.school.football.resp.sys.QueryRolePageResp;
import com.sjht.school.football.service.sys.SysPermissionService;
import com.sjht.school.football.service.sys.SysRoleService;
import com.sjht.school.football.service.sys.SysUserService;
import com.sjht.school.football.shiro.MyShiroRealm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/sys/role")
public class SysteRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private MyShiroRealm myShiroRealm;

    /**
     * 去角色页面
     * @param loginUserReq
     * @return
     */
    @GetMapping("/roleListPage")
    public String login(LoginUserReq loginUserReq) {
        return "role/list";
    }

    /**
     * 分页查询叫色列表
     * @param queryRolePageReq
     * @return
     */
    @PostMapping("/queryRolePage")
    @ResponseBody
    public PageResult<QueryRolePageResp> queryUserPage(QueryRolePageReq queryRolePageReq){
        return sysRoleService.querRolePageList(queryRolePageReq);
    }

    /**
     * 添加角色
     * @param addRoleReq
     * @return
     */
    @PostMapping("/addRole")
    @ResponseBody
    public BaseResponse addRole(AddRoleReq addRoleReq){
        return sysRoleService.addRole(addRoleReq);
    }

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @GetMapping("/deleteRole")
    @ResponseBody
    public BaseResponse deleteRole(String roleId){
        return sysRoleService.deleteRole(roleId);
    }

    /**
     * 去编辑页面
     * @param model
     * @param id
     * @return
     */
    @GetMapping("/edit")
    public String edit(Model model, String id) {
        SysRoleEntity role = sysRoleService.roleInfo(id);
        model.addAttribute("role", role);
        return "role/detail";
    }

    /**
     * 提交编辑
     * @param sysRoleEntity
     * @return
     */
    @PostMapping("/submitEdit")
    @ResponseBody
    public BaseResponse submitEdit(SysRoleEntity sysRoleEntity){
        return  sysRoleService.submitEdit(sysRoleEntity);
    }

    @PostMapping("/assign/permission/list")
    @ResponseBody
    public List<PermissionTreeListResp> assignRole(String roleId){
        List<PermissionTreeListResp> listVos = new ArrayList<>();
        List<QueryPermissionListResp> allPermissions = permissionService.queryPermissionList("1");
        List<PermissionEntity> hasPermissions = permissionService.findByRoleId(roleId);
        for(QueryPermissionListResp permission : allPermissions){
            PermissionTreeListResp vo = new PermissionTreeListResp();
            vo.setId(permission.getId());
            vo.setPermissionId(permission.getId());
            vo.setName(permission.getName());
            vo.setParentId(permission.getParentId());
            for(PermissionEntity hasPermission: hasPermissions){
                //有权限则选中
                if(hasPermission.getId().equals(permission.getId())){
                    vo.setChecked(true);
                    break;
                }
            }
            listVos.add(vo);
        }
        return listVos;
    }

    /**
     * 给角色分配权限
     * @param roleId
     * @param permissionIdStr
     * @return
     */
    @PostMapping("/assign/assignPermissionByRole")
    @ResponseBody
    public BaseResponse assignPermissionByRole(String roleId, String permissionIdStr){
        List<String> permissionIdsList = new ArrayList<>();
        if(StringUtils.isNotBlank(permissionIdStr)){
            String[] permissionIds = permissionIdStr.split(",");
            permissionIdsList = Arrays.asList(permissionIds);
        }
        BaseResponse baseResponse = permissionService.assignPermissionByRole(roleId, permissionIdsList);
        List<String> userIds = sysUserService.getUserIds(roleId);
        myShiroRealm.clearAuthorizationByUserId(userIds);
        return baseResponse;
    }

    @PostMapping("/assignRole/getRoleList")
    @ResponseBody
    public Map<String,Object> getRoleList(String userId){
        List<SysRoleEntity> roleList = sysRoleService.getAllRoleList();
        Set<String> hasRoles = sysRoleService.getRoleIds(userId);
        Map<String, Object> jsonMap = new HashMap<>(2);
        jsonMap.put("rows", roleList);
        jsonMap.put("hasRoles",hasRoles);
        return jsonMap;
    }

    /**保存分配角色*/
    @PostMapping("/assign/submitRole")
    @ResponseBody
    public BaseResponse assignRole(String userId, String roleIdStr){
        BaseResponse baseResponse = sysRoleService.assignRole(userId, roleIdStr);
        List<String> userIds = new ArrayList<>();
        userIds.add(userId);
        myShiroRealm.clearAuthorizationByUserId(userIds);
        return baseResponse;
    }
}
