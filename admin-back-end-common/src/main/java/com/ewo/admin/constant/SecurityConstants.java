package com.ewo.admin.constant;


/**
 * @author wangruiheng
 */
public interface SecurityConstants {
    /**
     * {bcrypt} 加密的特征码
     */
    String BCRYPT = "bcrypt";

    /**
     * {SHA-1} 加密的特征码
     */
    String SHA_1 = "SHA-1";

    /**
     * {noop} 加密的特征码
     */
    String NOOP = "noop";

    // 密码模式授权模式
    String GRANT_TYPE_PASSWORD = "password";
    //授权码模式
     String AUTHORIZATION_CODE = "authorization_code";
    //refresh token模式
    String REFRESH_TOKEN = "refresh_token";
    //简化授权模式
    String IMPLICIT = "implicit";

    /**
     * 升级中
     */
    String UPGRADING = "{\"rtnCode\":\"500\",\"rtnMsg\":\"系统升级中，请稍后再访问...\"}";

    /**
     * 没有权限提示
     */
    String FORBIDDEN_MSG = "{\"rtnCode\":\"403\",\"rtnMsg\":\"权限不足\"}";

    /**
     * 没有登录提示
     */
    String UNAUTHORIZED_MSG = "{\"rtnCode\":\"401\",\"rtnMsg\":\"拒绝访问\"}";
}
