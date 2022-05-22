package com.ewo.admin.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 授权认证
 *
 * @author wangruiheng
 * @date 2022/05/12 18:05
 **/
@SpringBootApplication
@MapperScan("com.ewo.admin.auth.mapper")
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}
