package com.okman.shop.upms.facade.fallback;

import com.okman.shop.common.model.Result;
import com.okman.shop.upms.facade.feign.FeignLogService;
import com.okman.shop.upms.service.entity.SysLog;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 日志Feign调用服务回调实现
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：日志Feign调用服务回调实现
 * @Date 2021/1/10 12:26
 */

@Slf4j
@Component
public class FeignLogServiceFallbackImpl implements FeignLogService {
    @Setter
    private Throwable cause;

    /**
     * 保存日志
     * @param sysLog 日志实体
     * @param from 内部调用标志
     * @return success、false
     */
    @Override
    public Result<Boolean> saveLog(SysLog sysLog, String from) {
        log.error("feign 插入日志失败", cause);
        return null;
    }
}
