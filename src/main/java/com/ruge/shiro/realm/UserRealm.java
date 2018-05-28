package com.ruge.shiro.realm;

import com.ruge.system.entity.SysMenu;
import com.ruge.system.entity.SysRole;
import com.ruge.system.entity.SysUser;
import com.ruge.system.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-26  10:16
 * 描述 ：自定义的userRealm
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;

    @Override
    public String getName() {
        return "UserRealm";
    }

    /**
     * 添加角色
     * @param username
     * @param info
     */
    private void addRole(String username, SimpleAuthorizationInfo info) {
        List<SysRole> roles = null;//roleDao.findByUser(username);
        if(roles!=null&&roles.size()>0){
            for (SysRole role : roles) {
                info.addRole(role.getRoleName());
            }
        }
    }

    /**
     * 添加权限
     * @param username
     * @param info
     * @return
     */
    private SimpleAuthorizationInfo addPermission(String username,SimpleAuthorizationInfo info) {
        List<SysMenu> permissions = null;// permissionDao.findPermissionByName(username);
        for (SysMenu permission : permissions) {
            info.addStringPermission(permission.getMenuUrl());//添加权限
        }
        return info;
    }
    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("开始授权把");
        //用户名
        String username = (String) principalCollection.fromRealm(getName()).iterator().next();
        List<String> menuList = new ArrayList<>();
        //根据用户名来添加相应的权限和角色
        if(!StringUtils.isEmpty(username)){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            addPermission(username,info);
            addRole(username, info);
            return info;
        }
        return null;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        SysUser bean = new SysUser();
        bean.setUserMobile(username);
        SysUser user = sysUserService.selectOne(bean);

        //账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        //密码错误
        if (!password.equals(user.getPassWord())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        //账号锁定
        if (user.getUserStatus() == 0) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
        return info;
    }
}
