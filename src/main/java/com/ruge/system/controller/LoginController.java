package com.ruge.system.controller;

import com.ruge.system.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


/**
 * 创建人 ：爱丽丝、如歌
 * 创建时间 ：2018-05-26  10:59
 * 描述 ：登录的控制器
 */
@Controller
@RequestMapping(value = "system")
public class LoginController {

    /**
     * 登录页面
     */
    @RequestMapping(value = "login.do", method = RequestMethod.GET)
    public String login() {
        return "system/sysLogin";
    }

    /**
     * 登录成功页面跳转
     */
    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String main(){
        return "system/sysMain";
    }
    /**
     * 登录验证
     */
    @RequestMapping(value = "checkLogin.do", method = RequestMethod.POST)
    @ResponseBody
    public Map checkLogin(SysUser user) {
        String msg = "登录成功";
        boolean result = true;
        Map map = new HashMap();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserMobile(), user.getPassWord());
        try {
            subject.login(token);
        } catch (Exception e) {
            msg = "登录失败";
            result = false;
        }finally {
            map.put("msg",msg);
            map.put("result",result);
        }
        return map;
    }
}
