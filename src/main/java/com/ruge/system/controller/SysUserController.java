package com.ruge.system.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruge.system.entity.SysUser;
import com.ruge.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * 爱丽丝、如歌  创建于 2018/5/16 14:47
 * 说明:  系统用户的controller层
 */
@Controller
@RequestMapping("sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "init.do", method = RequestMethod.GET)
    public String init() {
        return "system/sysUserList";
    }

    /**
     * 跳转至编辑页面
     * @return
     */
    @RequestMapping(value = "form.do", method = RequestMethod.GET)
    public String form(String userId,Model model) {
        //1.创建Example对象
        Example example = new Example(SysUser.class);
        //2.通过Example对象创建Criteria对象
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        List<SysUser> sysUsers = sysUserService.selectByExample(example);
        model.addAttribute("time",new Date());
        model.addAttribute("user",sysUsers.get(0));
        return "system/sysUserForm";
    }
    /**
     * 表单数据回显
     * @param userId
     * @return
     */
    @RequestMapping(value = "formDetail.do", method = RequestMethod.GET)
    public String formDetail(String userId) {
        Map map = new HashMap();
        String msg = "成功";
        int code = 0;
        List<SysUser> sysUsers = new ArrayList<>();
        //1.创建Example对象
        Example example = new Example(SysUser.class);
        //2.通过Example对象创建Criteria对象
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        try{
            sysUsers = sysUserService.selectByExample(example);
        }catch (Exception e){
            msg = "错误";
            code = -1;
        }
        map.put("data", sysUsers);
        map.put("msg", msg);
        map.put("code", code);
        map.put("count", sysUsers.size());
        return "";
    }

    /**
     * 页面数据查询
     * @param page  当前页码
     * @param limit 每页显示数量
     * @param bean 实体类
     * @return 返回的json数据
     */
    @RequestMapping(value = "list.do", method = RequestMethod.GET)
    @ResponseBody
    public Map list(int page, int limit, SysUser bean) {
        Map map = new HashMap();
        Example example = new Example(SysUser.class);
        example.setDistinct(true);
        example.setOrderByClause("user_Id desc");
        PageHelper.startPage(page, limit);
        List<SysUser> sysUsers = sysUserService.selectByExample(example);
        PageInfo pageInfo = new PageInfo<>(sysUsers);
        map.put("data", pageInfo.getList());
        map.put("msg", "成功");
        map.put("code", 0);
        map.put("count", pageInfo.getTotal());
        return map;
    }

    @RequestMapping(value = "insert.do", method = RequestMethod.POST)
    @ResponseBody
    public String insert(@RequestBody SysUser model) {
        sysUserService.insertByModel(model);
        return "system/sysUserList";
    }

    @RequestMapping(value = "update.do", method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody SysUser model) {
        int i = sysUserService.updateByModel(model);
        return "system/sysUserList";
}

    @RequestMapping(value = "delete.do", method = RequestMethod.POST)
    public String delete(Example example) {
        sysUserService.deleteByModel(example);
        return "";
    }
}
