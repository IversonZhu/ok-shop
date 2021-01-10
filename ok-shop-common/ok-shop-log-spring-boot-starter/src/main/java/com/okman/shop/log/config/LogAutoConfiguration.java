package com.okman.shop.log.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.okman.shop.log.aspect.SysLogAspect;
import com.okman.shop.log.listener.SysLogListener;
import com.okman.shop.upms.facade.feign.FeignLogService;

import lombok.RequiredArgsConstructor;

/**
 * <p>
 * 日志自动配置
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：日志自动配置
 * @Date 2021/1/10 12:05
 */
@EnableAsync
@RequiredArgsConstructor
@ConditionalOnWebApplication
@Configuration(proxyBeanMethods = false)
public class LogAutoConfiguration {

    private final FeignLogService feignLogService;

    @Bean
    public SysLogListener sysLogListener() {
        return new SysLogListener(feignLogService);
    }

    @Bean
    public SysLogAspect sysLogAspect() {
        return new SysLogAspect();
    }
}
