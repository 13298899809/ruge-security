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

    @RequestMapping(value = "init.do", method = RequestMethod.GET)
    public String init() {
        return "system/sysUserList";
    }

    /**
     * 跳转至编辑页面
     * @return
     */
    @RequestMapping(value = "form.do", method = RequestMethod.GET)
    public ModelAndView form(String userId) {
        String viewName = "system/sysUserForm";//视图名
        ModelAndView modelAndView = new ModelAndView(viewName);
        //1.创建Example对象
        Example example = new Example(SysUser.class);
        //2.通过Example对象创建Criteria对象
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        List<SysUser> sysUsers = sysUserService.selectByExample(example);
        return modelAndView;
    }

    /**
     * 页面数据查询
     * @param curr  当前页码
     * @param limit 每页显示数量
     * @param bean 实体类
     * @return 返回的json数据
     */
    @RequestMapping(value = "list.do", method = RequestMethod.GET)
    @ResponseBody
    public Map list(int curr, int limit, SysUser bean) {
        Map map = new HashMap();
        Example example = new Example(SysUser.class);
        example.setDistinct(true);
        example.setOrderByClause("user_Id desc");
        PageHelper.startPage(curr, limit);
        List<SysUser> sysUsers = sysUserService.selectByExample(example);
        PageInfo pageInfo = new PageInfo<>(sysUsers);
        map.put("dataList", pageInfo.getList());
        map.put("pageNavige", pageInfo.getNavigateFirstPage());
        map.put("total", pageInfo.getTotal());
        return map;
    }

    @RequestMapping(value = "insert.do", method = RequestMethod.POST)
    @ResponseBody
    public String insert(@RequestBody SysUser model) {
        System.out.println(model);
        sysUserService.insertByModel(model);
        return "system/sysUserList";
    }

    @RequestMapping(value = "update.do", method = RequestMethod.POST)
    public String update(SysUser model, Example example) {
        sysUserService.updateByModel(model, example);
        return "";
    }

    @RequestMapping(value = "delete.do", method = RequestMethod.POST)
    public String delete(Example example) {
        sysUserService.deleteByModel(example);
        return "";
    }
}
