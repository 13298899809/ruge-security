package com.ruge.system.service;

import com.ruge.system.entity.SysUser;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 爱丽丝、如歌 创建于 2018/5/16 14:49
 * 说明:  系统用户的service
 */
public interface SysUserService {
    public List<SysUser> selectByExample(Example example);

    public SysUser selectOne(SysUser model);

    public int insertByModel(SysUser model);

    public int updateByModel(SysUser model);

    public int deleteByModel(Example example);
}
