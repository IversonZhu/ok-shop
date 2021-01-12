package com.okman.shop.security.properties;

import cn.hutool.core.util.ReUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.okman.shop.security.annotation.NotAuth;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * <p>
 * 资源服务器对外直接暴露URL,如果设置context-path 要特殊处理
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：资源服务器对外直接暴露URL,如果设置context-path 要特殊处理
 * @Date 2021/1/12 10:46
 */
@Configuration
@ConfigurationProperties(prefix = "security.oauth2.ignore")
public class PermitAllUrlProperties implements InitializingBean, ApplicationContextAware {

    private static final Pattern PATTERN = Pattern.compile("\\{(.*?)\\}");

    private ApplicationContext applicationContext;

    @Getter
    @Setter
    private List<String> urls = new ArrayList<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();

        map.keySet().forEach(info -> {
            HandlerMethod handlerMethod = map.get(info);

            // 获取方法上边的注解 替代path variable 为 *
            NotAuth method = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), NotAuth.class);
            Optional.ofNullable(method).ifPresent(inner -> info.getPatternsCondition().getPatterns()
                    .forEach(url -> urls.add(ReUtil.replaceAll(url, PATTERN, StringPool.ASTERISK))));

            // 获取类上边的注解, 替代path variable 为 *
            NotAuth controller = AnnotationUtils.findAnnotation(handlerMethod.getBeanType(), NotAuth.class);
            Optional.ofNullable(controller).ifPresent(inner -> info.getPatternsCondition().getPatterns()
                    .forEach(url -> urls.add(ReUtil.replaceAll(url, PATTERN, StringPool.ASTERISK))));
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
