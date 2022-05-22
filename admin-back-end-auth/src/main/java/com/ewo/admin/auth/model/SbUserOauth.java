package com.ewo.admin.auth.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.List;

/**
 * 用户表-第三方认证表
 * @author wangruiheng
 */
@Data
public class SbUserOauth implements UserDetails, Serializable {
    /**
    * 用户ID
    */
    @JsonIgnore
    private Long id;

    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 用户ID
     */
    @JsonIgnore
    private Long userId;

    /**
    * 用户名-账号
    */
    private String username;

    /**
    * 姓名
    */
    private String name;

    /**
    * 电邮地址
    */
    private String email;

    /**
    * 手机号
    */
    private String mobile;

    /**
    * 密码哈希
    */
    @JsonIgnore
    private String password;

    /**
    * 是否激活，默认激活
    */
    @JsonIgnore
    private Boolean enabled = true;

    /**
    * 账户是否未过期，默认未过期
    */
    @JsonIgnore
    private Boolean accountNonExpired = true;

    /**
    * 账户是否未锁定，默认未锁定
    */
    @JsonIgnore
    private Boolean accountNonLocked =  true;

    /**
    * 密码是否未过期，默认未过期
    */
    @JsonIgnore
    private Boolean credentialsNonExpired = true;

    /**
     * 权限列表
     */
    @TableField(exist = false)
    private List<GrantedAuthority> authorities;


    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}