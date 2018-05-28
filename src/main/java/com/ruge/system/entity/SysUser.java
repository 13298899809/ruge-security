package com.ruge.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 爱丽丝、如歌 创建于 2018年5月16日14:16:02
 * 说明: 系统用户
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * uuid
     */
    @Id
    private String userId;
    /**
     * 用户昵称
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;
    /**
     * 用户手机号
     */
    private String userMobile;
    /**
     * 用户邮箱
     */
    private String userEmail;
    /**
     * 用户生日
     */
    private String userBirthday;
    /**
     * 用户性别
     */
    private String userSex;
    /**
     * 座右铭
     */
    private String userMotto;

    /**
     * 状态  0：禁用   1：正常
     */
    private Integer userStatus;
    /**
     * 角色列表
     */
    private Set<SysRole> roleIdList = new HashSet<>();

    private String createUserId;
    private String createTime;
}
