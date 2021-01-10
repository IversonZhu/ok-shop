package com.okman.shop.upms.facade.factory;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.okman.shop.upms.facade.fallback.FeignLogServiceFallbackImpl;
import com.okman.shop.upms.facade.feign.FeignLogService;

/**
 * <p>
 * FeignLogServiceFallbackFactory
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/10 12:26
 */
@Component
public class FeignLogServiceFallbackFactory implements FallbackFactory<FeignLogService> {
    @Override
    public FeignLogService create(Throwable cause) {
        FeignLogServiceFallbackImpl feignLogServiceFallback = new FeignLogServiceFallbackImpl();
        feignLogServiceFallback.setCause(cause);
        return feignLogServiceFallback;
    }
}
