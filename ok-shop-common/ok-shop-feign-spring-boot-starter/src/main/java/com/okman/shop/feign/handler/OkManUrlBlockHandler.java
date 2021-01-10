package com.okman.shop.feign.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.okman.shop.common.model.Result;

import cn.hutool.http.ContentType;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * sentinel统一降级限流策略
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：sentinel统一降级限流策略
 * @Date 2021/1/9 18:32
 */
@Slf4j
public class OkManUrlBlockHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        log.error("sentinel 降级 资源名称{}", e.getRule().getResource(), e);
        httpServletResponse.setContentType(ContentType.JSON.toString());
        httpServletResponse.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
        httpServletResponse.getWriter().print(JSONUtil.toJsonStr(Result.failed(e.getMessage())));
    }
}
