package com.sjht.school.football.shiro;

import com.sjht.school.football.dao.sys.SysPermissionDao;
import com.sjht.school.football.dao.sys.SysRoleDao;
import com.sjht.school.football.dao.sys.SysUserDao;
import com.sjht.school.football.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 ************************************************
 *@ClassName MyShiroRealm
 *@Description 授权和认证
 *@Author maojianyun
 *@Date 2019/9/5 9:43
 *@Version V1.0
 *************************************************
 **/
@Component
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysRoleDao sysRoleDao;

    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Autowired
    private RedisSessionDAO redisSessionDAO;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("principals 不能为空");
        }
        SysUserEntity sysUserEntity = (SysUserEntity) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 查询角色和权限
        SysUserEntity user = (SysUserEntity) principals.getPrimaryPrincipal();
        info.setRoles(sysRoleDao.getRoleIds(user.getId()));
        info.setStringPermissions(sysPermissionDao.getPermissions(user.getId()));
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String name = upToken.getUsername();
        String pass = String.valueOf(upToken.getPassword());
        // 登录
        SysUserEntity sysUserEntity = sysUserDao.userLogin(name);
        if (sysUserEntity != null) {
            if ("2".equals(sysUserEntity.getStatus())) { // 账号被禁用
                throw new AuthenticationException("账号已被禁止登陆");
            }
        } else { // 用户名不存在
            throw new AuthenticationException("账号或密码错误");
        }
        return new SimpleAuthenticationInfo(sysUserEntity, sysUserEntity.getPassword(), getName());
    }

    /**
     * 根据userId 清除当前session存在的用户的权限缓存
     *
     * @param userIds 已经修改了权限的userId
     */
    public void clearAuthorizationByUserId(List<String> userIds) {
        if (null == userIds || userIds.size() == 0) {
            return;
        }
        List<SimplePrincipalCollection> list = getSpcListByUserIds(userIds);
        RealmSecurityManager securityManager =
                (RealmSecurityManager) SecurityUtils.getSecurityManager();
        MyShiroRealm realm = (MyShiroRealm) securityManager.getRealms().iterator().next();
        for (SimplePrincipalCollection simplePrincipalCollection : list) {
            realm.clearCachedAuthorizationInfo(simplePrincipalCollection);
        }
    }

    /**
     * 根据用户id获取所有spc
     *
     * @param userIds 已经修改了权限的userId
     */
    private List<SimplePrincipalCollection> getSpcListByUserIds(List<String> userIds) {
        //获取所有session
        Collection<Session> sessions = redisSessionDAO.getActiveSessions();
        //定义返回
        List<SimplePrincipalCollection> list = new ArrayList<>();
        for (Session session : sessions) {
            //获取session登录信息。
            Object obj = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (null != obj && obj instanceof SimplePrincipalCollection) {
                //强转
                SimplePrincipalCollection spc = (SimplePrincipalCollection) obj;
                //判断用户，匹配用户ID。
                obj = spc.getPrimaryPrincipal();
                if (null != obj && obj instanceof SysUserEntity) {
                    SysUserEntity user = (SysUserEntity) obj;
                    System.out.println("user:" + user);
                    //比较用户ID，符合即加入集合
                    if (null != user && userIds.contains(user.getId())) {
                        list.add(spc);
                    }
                }
            }
        }
        return list;
    }
}
