package com.sjht.school.football.shiro;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;

/**
 * ***************************************************
 * @ClassName PermsService
 * @Description js调用 thymeleaf 实现按钮权限
 * @Author maojianyun
 * @Date 2019/9/5 10:05
 * @Version V1.0
 * ****************************************************
 **/
@Component("perms")
public class PermsService {
    public boolean hasPerm(String permission) {
        return SecurityUtils.getSubject().isPermitted(permission);
    }
}
