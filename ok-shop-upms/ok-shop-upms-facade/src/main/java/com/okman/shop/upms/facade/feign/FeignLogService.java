package com.okman.shop.upms.facade.feign;

import com.okman.shop.common.constant.ServiceNameConstant;
import com.okman.shop.upms.facade.factory.FeignLogServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.okman.shop.common.constant.SysConstants;
import com.okman.shop.common.model.Result;
import com.okman.shop.upms.service.entity.SysLog;

/**
 * <p>
 * FeignLogService
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/10 12:22
 */
@FeignClient(contextId = "feignLogService", value = ServiceNameConstant.UMPS_SERVICE, fallbackFactory = FeignLogServiceFallbackFactory.class)
public interface FeignLogService {

    /**
     * 保存日志
     * @param sysLog 日志实体
     * @param from 内部调用标志
     * @return success、false
     */
    @PostMapping("/log")
    Result<Boolean> saveLog(@RequestBody SysLog sysLog, @RequestHeader(SysConstants.FROM) String from);
}
