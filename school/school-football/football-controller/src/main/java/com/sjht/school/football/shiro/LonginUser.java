package com.sjht.school.football.shiro;

import com.sjht.school.football.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * ***************************************************
 * @ClassName LonginUser
 * @Description 登录用户
 * @Author maojianyun
 * @Date 2019/9/18 10:27
 * @Version V1.0
 * ****************************************************
 **/
public class LonginUser {

    private static volatile LonginUser INSTANCE = null;

    private LonginUser(){

    }

    public static LonginUser getInstance(){
        if (null != INSTANCE) {
            synchronized (LonginUser.class){
                if (null != INSTANCE) {
                    INSTANCE = new LonginUser();
                }
            }
        }
        return INSTANCE;
    }

    public  SysUserEntity getLonginUser(){
        Subject subject = SecurityUtils.getSubject();
        SysUserEntity sysUserEntity = (SysUserEntity)subject.getPrincipal();
        return sysUserEntity;
    }


}
