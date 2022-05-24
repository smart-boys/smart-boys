package com.ewo.admin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
    * 用户表
    */
@ApiModel(value="com-ewo-admin-auth-model-SbUser")
@Data
public class SbUser {
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
    * 用户编号
    */
    @ApiModelProperty(value="用户编号")
    private String code;

    /**
    * 用户平台
    */
    @ApiModelProperty(value="用户平台")
    private Integer userType;

    /**
    * 账号
    */
    @ApiModelProperty(value="账号")
    private String account;

    /**
    * 密码
    */
    @ApiModelProperty(value="密码")
    private String password;

    /**
    * 昵称
    */
    @ApiModelProperty(value="昵称")
    private String name;

    /**
    * 真名
    */
    @ApiModelProperty(value="真名")
    private String realName;

    /**
    * 头像
    */
    @ApiModelProperty(value="头像")
    private String avatar;

    /**
    * 邮箱
    */
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
    * 手机
    */
    @ApiModelProperty(value="手机")
    private String phone;

    /**
    * 生日
    */
    @ApiModelProperty(value="生日")
    private Date birthday;

    /**
    * 性别
    */
    @ApiModelProperty(value="性别")
    private Integer sex;

    /**
    * 角色id
    */
    @ApiModelProperty(value="角色id")
    private String roleId;

    /**
    * 部门id
    */
    @ApiModelProperty(value="部门id")
    private String deptId;

    /**
    * 岗位id
    */
    @ApiModelProperty(value="岗位id")
    private String postId;

    /**
    * 创建人
    */
    @ApiModelProperty(value="创建人")
    private Long createUser;

    /**
    * 创建部门
    */
    @ApiModelProperty(value="创建部门")
    private Long createDept;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
    * 修改人
    */
    @ApiModelProperty(value="修改人")
    private Long updateUser;

    /**
    * 修改时间
    */
    @ApiModelProperty(value="修改时间")
    private Date updateTime;

    /**
    * 状态
    */
    @ApiModelProperty(value="状态")
    private Integer status;

    /**
    * 是否已删除
    */
    @ApiModelProperty(value="是否已删除")
    private Integer isDeleted;
}