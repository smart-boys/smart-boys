package com.ewo.admin.auth.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
    * 角色菜单关联表
    */
@ApiModel(value="com-ewo-admin-auth-model-SbRoleMenu")
@Data
public class SbRoleMenu {
    /**
    * 主键
    */
    @ApiModelProperty(value="主键")
    private Long id;

    /**
    * 菜单id
    */
    @ApiModelProperty(value="菜单id")
    private Long menuId;

    /**
    * 角色id
    */
    @ApiModelProperty(value="角色id")
    private Long roleId;
}