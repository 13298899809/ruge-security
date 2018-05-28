package com.ruge.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

/**
 * 爱丽丝、如歌 2018/5/16 13:53
 * 说明: 菜单管理
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 菜单ID
     */
    @Id
    private Long menuId;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单URL
     */
    private String menuUrl;

    /**
     * 父菜单ID，一级菜单为0
     */
    private Long parentId;

    /**
     * 父菜单名称
     */
    private String parentName;
    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String menuPerms;

    /**
     * 类型     0：目录   1：菜单   2：按钮
     */
    private Integer menuType;

    /**
     * 菜单图标
     */
    private String menuIcon;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * ztree属性
     */
    private Boolean open;

    private List<?> list;

    private List<SysMenu> children;

}
