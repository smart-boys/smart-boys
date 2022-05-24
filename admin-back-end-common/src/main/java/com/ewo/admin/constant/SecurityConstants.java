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

    /**
     * 升级中
     */
    String UPGRADING = "{\"code\":\"500\",\"msg\":\"系统升级中，请稍后再访问...\"}";

    /**
     * 没有权限提示
     */
    String FORBIDDEN_MSG = "{\"code\":\"403\",\"msg\":\"权限不足\"}";

    /**
     * 没有登录提示
     */
    String UNAUTHORIZED_MSG = "{\"code\":\"401\",\"msg\":\"拒绝访问\"}";
}
