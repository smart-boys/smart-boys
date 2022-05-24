package com.ewo.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
    * 菜单表
    */
@ApiModel(value="com-ewo-admin-auth-model-SbMenu")
@Data
public class SbMenu {
    /**
    * 主键
    */
    @ApiModelProperty(value="主键")
    private Long id;

    /**
    * 父级菜单
    */
    @ApiModelProperty(value="父级菜单")
    private Long parentId;

    /**
    * 菜单编号
    */
    @ApiModelProperty(value="菜单编号")
    private String code;

    /**
    * 菜单名称
    */
    @ApiModelProperty(value="菜单名称")
    private String name;

    /**
    * 菜单别名
    */
    @ApiModelProperty(value="菜单别名")
    private String alias;

    /**
    * 请求地址
    */
    @ApiModelProperty(value="请求地址")
    private String path;

    /**
    * 菜单资源
    */
    @ApiModelProperty(value="菜单资源")
    private String source;

    /**
    * 排序
    */
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
    * 菜单类型
    */
    @ApiModelProperty(value="菜单类型")
    private Integer category;

    /**
    * 操作按钮类型
    */
    @ApiModelProperty(value="操作按钮类型")
    private Integer action;

    /**
    * 是否打开新页面
    */
    @ApiModelProperty(value="是否打开新页面")
    private Integer isOpen;

    /**
    * 组件地址
    */
    @ApiModelProperty(value="组件地址")
    private String component;

    /**
    * 备注
    */
    @ApiModelProperty(value="备注")
    private String remark;

    /**
    * 是否已删除
    */
    @ApiModelProperty(value="是否已删除")
    private Integer isDeleted;
}