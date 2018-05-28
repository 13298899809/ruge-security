package com.ruge.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 爱丽丝、如歌 创建于 2018/5/16 13:47
 * 说明: 系统角色
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRole implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 用户列表
     */
    private Set<SysUser> userIdList = new HashSet<>();
    /**
     * 菜单列表
     */
    private Set<SysMenu> menuIdList = new HashSet<>();


    private Long createUserId;
    private Date createTime;
}