package com.ruge.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 爱丽丝、如歌 创建于 2018/5/16 13:47
 * 说明: 字典表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysCode {
    private Long id;
    /**
     * 编码值
     */
    private String code;
    /**
     * 编码名称
     */
    private String codeName;
    /**
     * 参数值
     */
    private String value;
    /**
     * 参数名
     */
    private String name;
    /**
     * 状态   0：隐藏   1：显示
     */
    private Integer status;
    /**
     * 父级id
     */
    private String pid;
    /**
     * 备注
     */
    private String remark;
}
