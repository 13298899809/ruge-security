package com.ruge.system.service.impl;

import com.ruge.system.dao.SysUserDao;
import com.ruge.system.entity.SysUser;
import com.ruge.system.service.SysUserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * 爱丽丝、如歌  创建于 2018/5/16 14:50
 * 说明:  用户service层
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    /**
     * 查询用户列表
     */
    @Override
    public List<SysUser> selectByExample(Example example) {
        return sysUserDao.selectByExample(example);
    }
    /**
     * 通过用户名查询用户信息 登录使用
     * @param model 用户名
     * @return 用户对象
     */
    @Override
    public SysUser selectOne(SysUser model) {
        return sysUserDao.selectOne(model);
    }

    @Override
    public int insertByModel(SysUser model){
        return sysUserDao.insertSelective(model);
    }
    @Override
    public int updateByModel(SysUser model){
        return sysUserDao.updateByPrimaryKeySelective(model);
    }
    @Override
    public int deleteByModel(SysUser model){
        return sysUserDao.deleteByPrimaryKey(model);
    }
}
