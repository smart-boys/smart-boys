package com.ewo.admin.annotation;

import java.lang.annotation.*;

/**
 * 加上此注解之后接口可以不需要token进行调用，也可以配置文件`ignore.ignore-urls`指定
 * 加在Controller类上表示整个类的所有接口都可以匿名访问
 * 如果加了这个注解的接口还传了token就必须保证token是有效的，否则返回401
 *
 * @author wangruiheng
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permit {
}