package com.ewo.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
    * 角色表
    */
@ApiModel(value="com-ewo-admin-auth-model-SbRole")
@Data
public class SbRole {
    /**
    * 主键
    */
    @ApiModelProperty(value="主键")
    private Long id;

    /**
    * 租户ID
    */
    @ApiModelProperty(value="租户ID")
    private String tenantId;

    /**
    * 父主键
    */
    @ApiModelProperty(value="父主键")
    private Long parentId;

    /**
    * 角色名
    */
    @ApiModelProperty(value="角色名")
    private String roleName;

    /**
    * 排序
    */
    @ApiModelProperty(value="排序")
    private Integer sort;

    /**
    * 角色别名
    */
    @ApiModelProperty(value="角色别名")
    private String roleAlias;

    /**
    * 是否已删除
    */
    @ApiModelProperty(value="是否已删除")
    private Integer isDeleted;
}