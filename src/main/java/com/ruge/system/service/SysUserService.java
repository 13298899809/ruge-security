package com.ruge.system.service;

import com.ruge.system.entity.SysUser;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 爱丽丝、如歌 创建于 2018/5/16 14:49
 * 说明:  系统用户的service
 */
public interface SysUserService {
    /**
     * 查询用户列表
     */
    public List<SysUser> selectByExample(Example example);

    /**
     * 通过用户名查询用户信息 登录使用
     * @param model 用户名
     * @return 用户对象
     */
    public SysUser selectOne(SysUser model);

    /**
     * 新增用户
     */
    public int insertByModel(SysUser model);

    /**
     * 更新用户
     */
    public int updateByModel(SysUser model);

    /**
     * 删除用户
     */
    public int deleteByModel(SysUser model);
}
