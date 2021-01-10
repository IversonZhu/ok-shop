package com.okman.shop.upms.service.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.okman.shop.upms.service.entity.SysLog;
import com.okman.shop.upms.service.mapper.SysLogMapper;
import com.okman.shop.upms.service.service.SysLogService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：日志表 服务实现类
 * @Date 2021/1/10 12:19
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {
//    @Override
//    public Page getLogByPage(Page page, SysLogDTO sysLog) {
//        return null;
//    }
}
