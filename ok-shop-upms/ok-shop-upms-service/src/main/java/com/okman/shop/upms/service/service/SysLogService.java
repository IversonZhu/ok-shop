package com.okman.shop.upms.service.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.okman.shop.upms.service.entity.SysLog;

/**
 * <p>
 * 日志表 服务类
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：日志表 服务类
 * @Date 2021/1/10 12:16
 */
public interface SysLogService extends IService<SysLog> {
    /**
     * 分页查询日志
     * @param page
     * @param sysLog
     * @return
     */
//    Page getLogByPage(Page page, SysLogDTO sysLog);
}
