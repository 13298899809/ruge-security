package com.ruge.system.service;

import com.ruge.system.entity.SysRole;
import com.ruge.system.entity.SysUser;

import java.util.List;

/**
 * 爱丽丝、如歌 创建于 2018/5/28 16:21
 * 说明:  TODO
 */
public interface SysRoleService {
    public List<SysRole> selectRoleByUser(SysUser model);
}
