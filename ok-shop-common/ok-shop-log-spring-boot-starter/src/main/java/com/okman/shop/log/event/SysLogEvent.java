package com.okman.shop.log.event;

import org.springframework.context.ApplicationEvent;

import com.okman.shop.upms.service.entity.SysLog;

/**
 * <p>
 * 系统日志事件
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：系统日志事件
 * @Date 2021/1/9 19:02
 */
public class SysLogEvent extends ApplicationEvent {
    public SysLogEvent(SysLog source) {
        super(source);
    }
}
