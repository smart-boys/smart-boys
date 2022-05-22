package com.ewo.admin.auth.config;/*
 * @description: Token相关配置
 * @author TAO
 * @date 2020/12/1 21:13
 */

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class TokenConfig {

    private String SIGNING_KEY = "signingKey";

    @Bean
    public TokenStore tokenStore() {
        //JWT令牌存储方案
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY); //对称秘钥，资源服务器使用该秘钥来验证
        return converter;
    }

    //JWT添加自定义数据
    @Bean
    @ConditionalOnMissingBean(name="jwtTokenEnhancer")//这里中的是为了让我们自己的业务系统也可以提供自己的自定义数据模板
    public TokenEnhancer jwtTokenEnhancer(){
        return new TokenJwtEnhancer();
    }


}

