package com.ewo.admin.auth.config;

import com.ewo.admin.auth.properties.SecurityPermitAllProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * Security配置
 * @author wangruiheng
 * @date 2022/05/20 11:22
 **/
@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final SecurityPermitAllProperties permitAllProperties;
    private final AuthenticationEntryPoint authenticationEntryPoint;


    /**
     * 配置拦截验证规则
     * @author wangruiheng
     * @date 2022/05/22 10:00
     * @param http
     * @return void
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()//允许基于使用HttpServletRequest限制访问
                .anyRequest().authenticated()// 拦截全部请求
                .and().formLogin()//指定支持基于表单的身份验证
                .and().httpBasic().authenticationEntryPoint(authenticationEntryPoint)//配置 Http Basic 验证
                .and().csrf().disable();
    }

    /**
     * 配置不进行拦截的资源
     * @author wangruiheng
     * @date 2022/05/22 09:53
     * @param web 
     * @return void 
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        String[] ignoreUrlArr = permitAllProperties.getIgnoreUrls().stream().toArray(String[]::new);
        web
                .ignoring()
                .antMatchers(ignoreUrlArr)
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }


    /**
     * Spring Security OAuth2 支持 password 这种 grant_type ，
     * 那么此处必须要暴露出 AuthenticationManager
     * @author wangruiheng
     * @date 2022/05/22 09:51
     * @return org.springframework.security.authentication.AuthenticationManager
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}
