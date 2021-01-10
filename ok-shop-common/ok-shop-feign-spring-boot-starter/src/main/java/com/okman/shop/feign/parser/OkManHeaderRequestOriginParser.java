package com.okman.shop.feign.parser;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * OkManHeaderRequestOriginParser
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：sentinel 请求头解析判断
 * @Date 2021/1/9 18:26
 */
public class OkManHeaderRequestOriginParser implements RequestOriginParser {

    /**
     * 请求头获取allow
     */
    private static final String ALLOW = "Allow";

    /**
     * Parse the origin from given HTTP request.
     * @param request HTTP request
     * @return parsed origin
     */
    @Override
    public String parseOrigin(HttpServletRequest request) {
        return request.getHeader(ALLOW);
    }
}
