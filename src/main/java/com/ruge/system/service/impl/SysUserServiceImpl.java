package com.ruge.system.service.impl;

import com.ruge.system.dao.SysUserDao;
import com.ruge.system.entity.SysUser;
import com.ruge.system.service.SysUserService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 爱丽丝、如歌  创建于 2018/5/16 14:50
 * 说明:  用户service层
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public List<SysUser> selectByExample(Example example) {
        return sysUserDao.selectByExample(example);
    }
    @Override
    public int insertByModel(SysUser model){
        return sysUserDao.insertSelective(model);
    }
    @Override
    public int updateByModel(SysUser model,Example example){
        return sysUserDao.updateByExampleSelective(model, example);
    }
    @Override
    public int deleteByModel(Example example){
        return sysUserDao.deleteByExample(example);
    }
}
