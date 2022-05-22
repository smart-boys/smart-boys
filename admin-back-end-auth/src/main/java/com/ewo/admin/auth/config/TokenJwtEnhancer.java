package com.ewo.admin.auth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TAO
 * @description: 给生成的jwt签名中添加自定义数据
 * @date 2020/12/12 0:20
 */
@Slf4j
public class TokenJwtEnhancer implements TokenEnhancer {

    /**
     * 添加jwt扩展信息
     * @author wangruiheng
     * @date 2022/05/22 22:10
     * @param accessToken
     * @param authentication
     * @return org.springframework.security.oauth2.common.OAuth2AccessToken
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, String> requestParameters = authentication.getOAuth2Request().getRequestParameters();//端点信息
        Authentication userAuthentication = authentication.getUserAuthentication();//登录用户信息
        Map<String, Object> info = new HashMap<>();
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);//设置附加信息
        return accessToken;
    }
}

