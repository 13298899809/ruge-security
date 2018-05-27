package com.ruge.shiro.realm;

import com.ruge.system.entity.SysUser;
import com.ruge.system.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-26  10:16
 * 描述 ：自定义的userRealm
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
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
