package com.okman.shop.log.listener;

import com.okman.shop.common.constant.SysConstants;
import com.okman.shop.upms.facade.feign.FeignLogService;
import com.okman.shop.upms.service.entity.SysLog;
import com.okman.shop.log.event.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

/**
 * <p>
 * 异步监听日志事件
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：异步监听日志事件
 * @Date 2021/1/10 12:07
 */

@Slf4j
@RequiredArgsConstructor
public class SysLogListener {

    private final FeignLogService feignLogService;

    @Async
    @Order
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event) {
        SysLog sysLog = (SysLog) event.getSource();
        feignLogService.saveLog(sysLog, SysConstants.FROM_IN);
    }
}
