package com.ewo.admin.auth.properties;

import cn.hutool.core.util.ReUtil;
import com.ewo.admin.auth.annotation.Permit;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * @author wangruiheng
 */
@Component
@ConfigurationProperties(prefix = "ignore")
public class SecurityPermitAllProperties implements InitializingBean {

    private static final Pattern PATTERN = Pattern.compile("\\{(.*?)\\}");
    private static final String ASTERISK = "*";
    private final RequestMappingHandlerMapping requestMappingHandlerMapping;
    /**
     * 需要排除的路径
     */
    @Setter
    @Getter
    private List<String> ignoreUrls = new ArrayList<>();

    public SecurityPermitAllProperties(RequestMappingHandlerMapping requestMappingHandlerMapping) {
        this.requestMappingHandlerMapping = requestMappingHandlerMapping;
    }

    @Override
    public void afterPropertiesSet() {
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();

        map.keySet().forEach(info -> {
            HandlerMethod handlerMethod = map.get(info);

            // 获取方法上边的注解 替代path variable 为 *
            Permit method = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), Permit.class);
            Optional.ofNullable(method)
                    .ifPresent(inner -> info.getPatternsCondition().getPatterns()
                            .forEach(url -> ignoreUrls.add(ReUtil.replaceAll(url, PATTERN, ASTERISK))));

            // 获取类上边的注解, 替代path variable 为 *
            Permit controller = AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), Permit.class);
            Optional.ofNullable(controller)
                    .ifPresent(inner -> info.getPatternsCondition().getPatterns()
                            .forEach(url -> ignoreUrls.add(ReUtil.replaceAll(url, PATTERN, ASTERISK))));
        });
    }
}
