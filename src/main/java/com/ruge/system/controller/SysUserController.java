package com.ruge.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruge.system.entity.SysUser;
import com.ruge.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 爱丽丝、如歌  创建于 2018/5/16 14:47
 * 说明:  系统用户的controller层
 */
@Controller
@RequestMapping("sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "init.do",method = RequestMethod.GET)
    public String init(){
        return "system/sysUserList";
    }
    @RequestMapping(value = "form.do",method = RequestMethod.GET)
    public String form(){
        return "system/sysUserForm";
    }
    @RequestMapping(value = "list.do",method = RequestMethod.POST)
    public String list(SysUser bean){
        Example example = new Example(SysUser.class);
        example.setDistinct(true);
        PageHelper.startPage(1, 10);
        List<SysUser> sysUsers = sysUserService.selectByExample(example);
        PageInfo pageInfo = new PageInfo<>(sysUsers);
        Map map = new HashMap();
        map.put(1, pageInfo.getPageNum());
        map.put(10, pageInfo.getPageSize());
        map.put(2, pageInfo.getStartRow());
        map.put(12, pageInfo.getEndRow());
        map.put(183, pageInfo.getTotal());
        map.put(19, pageInfo.getPages());
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("key=" + key + " value=" + value);
        }
        return "";
    }
    @RequestMapping(value = "insert.do",method = RequestMethod.POST)
    public String insert(SysUser model){
        sysUserService.insertByModel(model);
        return "";
    }
    @RequestMapping(value = "update.do",method = RequestMethod.POST)
    public String update(SysUser model,Example example){
        sysUserService.updateByModel(model,example);
        return "";
    }
    @RequestMapping(value = "delete.do",method = RequestMethod.POST)
    public String delete(Example example){
        sysUserService.deleteByModel(example);
        return "";
    }
}
