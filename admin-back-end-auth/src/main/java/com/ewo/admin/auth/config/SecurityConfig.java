package com.ewo.admin.auth.config;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.ewo.admin.auth.constant.SecurityConstants;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.Map;

import static com.ewo.admin.auth.constant.SecurityConstants.UNAUTHORIZED_MSG;
import static com.ewo.admin.auth.constant.SecurityConstants.UPGRADING;

/**
 * @author wangruiheng
 */
@Configuration
public class SecurityConfig {


    /**
     * 支持不同的加密算法
     * @author wangruiheng
     * @date 2022/05/22 09:49
     * @return org.springframework.security.crypto.password.PasswordEncoder
     */
    @Bean
    @ConditionalOnMissingBean
    public PasswordEncoder passwordEncoder() {
        // 支持的多种编码器
        Map<String, PasswordEncoder> encoders = new HashMap<>(3);
        encoders.put(SecurityConstants.BCRYPT,new BCryptPasswordEncoder());
        encoders.put(SecurityConstants.SHA_1, new MessageDigestPasswordEncoder(SecurityConstants.SHA_1));
        encoders.put(SecurityConstants.NOOP, NoOpPasswordEncoder.getInstance());
        return new DelegatingPasswordEncoder(SecurityConstants.BCRYPT, encoders);
    }

    @Bean
    @ConditionalOnMissingBean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, e) -> {
            response.setStatus(HttpStatus.OK.value());
            Throwable throwable = ExceptionUtil.getCausedBy(e, ResourceAccessException.class);
            if (throwable != null) {
                ServletUtil.write(response, UPGRADING, "application/json;charset=UTF-8");
            } else {
                ServletUtil.write(response, UNAUTHORIZED_MSG, "application/json;charset=UTF-8");
            }
        };
    }

    @Bean
    @ConditionalOnMissingBean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, e) -> {
            response.setStatus(HttpStatus.OK.value());
            ServletUtil.write(response, SecurityConstants.FORBIDDEN_MSG, "application/json;charset=UTF-8");
        };
    }
}
