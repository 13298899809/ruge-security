package com.ruge.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 爱丽丝、如歌  创建于 2018/5/28 16:17
 * 说明:  角色控制器
 */
@Controller
public class SysRoleController {
    /**
     * 查询该用户下的角色列表
     * @return
     */
    @RequestMapping
    @ResponseBody
    public Map selectByUser(){
        Map map = new HashMap();

        return map;
    }
}
