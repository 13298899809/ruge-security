package com.ruge.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 爱丽丝、如歌 创建于 2018年5月16日14:16:02
 * 说明: 系统用户
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;
    private String userName;
    private String passWord;
    private String userMobile;
    private String userEmail;
    /**
     * 状态  0：禁用   1：正常
     */
    private Integer userStatus;

    private List<Long> roleIdList;

    private String createUserId;
    private String createTime;
}
