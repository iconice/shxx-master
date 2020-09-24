package com.sjht.school.football.controller.sys;

import com.sjht.school.common.entity.BaseResponse;
import com.sjht.school.common.entity.PageResult;
import com.sjht.school.common.entity.ResultUtil;
import com.sjht.school.football.entity.SysUserEntity;
import com.sjht.school.football.req.football.student.EditUserReq;
import com.sjht.school.football.req.sys.AddUserReq;
import com.sjht.school.football.req.sys.LoginUserReq;
import com.sjht.school.football.req.sys.QueryUserPageReq;
import com.sjht.school.football.req.sys.UpdateUserReq;
import com.sjht.school.football.service.sys.SysUserService;
import com.xiaoleilu.hutool.crypto.SecureUtil;
import org.apache.catalina.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.subject.Subject;
import org.crazycake.shiro.RedisCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.Deque;

@Controller
@RequestMapping("/sys/user")
public class SystemUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisCacheManager redisCacheManager;

    /**
     * 去登录页面
     *
     * @param loginUserReq
     * @return
     */
    @GetMapping("/login")
    public String login(LoginUserReq loginUserReq) {
        return "system/login";
    }

    /**
     * 提交登录
     *
     * @param username
     * @param password
     * @param verification
     * @return
     */
    @PostMapping("/submiLogin")
    @ResponseBody
    public BaseResponse submiLogin(String username, String password, String verification) {
        LoginUserReq loginUserReq = new LoginUserReq(username, password, verification);
        BaseResponse baseResponse = sysUserService.loginUser(loginUserReq);
        return baseResponse;
    }

    @RequestMapping(value = "/logout")
    @ResponseBody
    public BaseResponse logout() {
        Subject subject = SecurityUtils.getSubject();
        if (null != subject) {
            String username = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getUserName();
            Serializable sessionId = SecurityUtils.getSubject().getSession().getId();
            Cache<String, Deque<Serializable>> cache = redisCacheManager.getCache(redisCacheManager.getKeyPrefix() + username);
            Deque<Serializable> deques = cache.get(username);
            if (null != deques) {
                for (Serializable deque : deques) {
                    if (sessionId.equals(deque)) {
                        deques.remove(deque);
                        break;
                    }
                }
                cache.put(username, deques);
            }
        }
        subject.logout();
        return ResultUtil.OK("退出成功");
    }


    /**
     * 跳转到用户列表页面
     *
     * @return
     */
    @GetMapping("/userListPage")
    public String queryUserList() {
        return "user/list";
    }

    @PostMapping("/queryUserPage")
    @ResponseBody
    public PageResult queryUserPage(QueryUserPageReq queryUserPageReq) {
        return sysUserService.queryUserPage(queryUserPageReq);
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return
     */
    @GetMapping("/deleteUserById")
    @ResponseBody
    public BaseResponse deleteUserById(String userId) {
        return sysUserService.deleteUserById(userId);
    }

    @PostMapping("/addUser")
    @ResponseBody
    public BaseResponse addUser(AddUserReq addUserReq) {
        return sysUserService.addUser(addUserReq);
    }

    @GetMapping("/editUser")
    public String editUser(Model model, String userId) {
        SysUserEntity info = sysUserService.getUserInfo(userId);
        model.addAttribute("user", info);
        return "user/userDetail";
    }

    @PostMapping("/submitEditUser")
    @ResponseBody
    public BaseResponse submitEditUser(EditUserReq userEntity) {
        return sysUserService.submitEditUser(userEntity);
    }


    /**
     * 用户更改密码
     *
     * @param updateUserReq
     * @return
     */
    @RequestMapping(value = "/changePassword")
    @ResponseBody
    public BaseResponse changePassword(UpdateUserReq updateUserReq) {
        Subject subject = SecurityUtils.getSubject();
        if (null != subject) {
            // 获取当前旧密码
            String oldPassword = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getPassword();

            String userId = ((SysUserEntity) SecurityUtils.getSubject().getPrincipal()).getId();
            updateUserReq.setUserId(userId);
            //验证确认密码是否相同
            if (!updateUserReq.getNewPassword().equals(updateUserReq.getConfirmNewPassword())) {
                return ResultUtil.error("请确认密码是否相同！");
            }
            //是否匹配原密码
            if (updateUserReq.getOldPassword() != null) {
                if (SecureUtil.md5(updateUserReq.getOldPassword()).equals(oldPassword)) {
                    updateUserReq.setNewPassword(SecureUtil.md5(updateUserReq.getNewPassword()));
                    return sysUserService.updatePassWordById(updateUserReq);
                } else {
                    return ResultUtil.OK("旧密码不正确！");
                }
            } else {
                return ResultUtil.error("旧密码不能为空！");
            }
        }
        return null;
    }

}
