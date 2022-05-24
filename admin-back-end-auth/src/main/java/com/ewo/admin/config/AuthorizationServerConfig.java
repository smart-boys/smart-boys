package com.ewo.admin.config;

import com.ewo.admin.service.SbUserOauthServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * 认证服务器配置
 *
 * @author wangruiheng
 */
@Configuration
@RequiredArgsConstructor
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final AuthenticationManager authenticationManager;
    private final SbUserOauthServiceImpl userDetailsService;
    private final DataSource dataSource;
    private final PasswordEncoder passwordEncoder;
    private final TokenEnhancer jwtTokenEnhancer;
    private final JwtAccessTokenConverter jwtAccessTokenConverter;


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .jdbc(dataSource)
                .passwordEncoder(passwordEncoder);
    }

    /**
     * 配置授权访问的接入点
     * @param endpoints
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .authenticationManager(authenticationManager) // 配置认证 manager
                .userDetailsService(userDetailsService); // 配置用户

        TokenEnhancerChain enhancerChain=new TokenEnhancerChain();
        List<TokenEnhancer> enhancers=new ArrayList<>();
        enhancers.add(jwtTokenEnhancer);
        enhancers.add(jwtAccessTokenConverter);//将普通的token转换为jwt
        enhancerChain.setTokenEnhancers(enhancers);
        endpoints
                .tokenEnhancer(enhancerChain)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST,HttpMethod.PUT,HttpMethod.DELETE,HttpMethod.OPTIONS);// 从 token 中读取特定字段构成 Authentication;
    }

    /**
     * 配置授权服务器的 token 接入点
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                //默认请求获取token的接入点开放
                .tokenKeyAccess("permitAll()")
                //检查token的接入点必须是认证过的
                .checkTokenAccess("isAuthenticated()")
                //允许表单提交
                .allowFormAuthenticationForClients();
    }
    /**
     * 配置密码编码器
     * @return
     */
    @Bean
    public JdbcClientDetailsService jdbcClientDetailsService() {
        val service = new JdbcClientDetailsService(dataSource);
        service.setPasswordEncoder(passwordEncoder);
        return service;
    }

}
