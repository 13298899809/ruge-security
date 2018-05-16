package com.ruge.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 爱丽丝、如歌 创建于 2018/5/16 13:47
 * 说明: 系统角色
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRole implements Serializable {
    private static final long serialVersionUID = 1L;
    private String orgId;
    private Long roleId;
    private String roleName;
    private String remark;
    private List<Long> menuIdList;

    private Long createUserId;
    private Date createTime;
}