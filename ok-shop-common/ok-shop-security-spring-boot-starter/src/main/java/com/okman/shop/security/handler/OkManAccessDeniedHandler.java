package com.okman.shop.security.handler;

import cn.hutool.http.HttpStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.okman.shop.common.constant.CommonConstants;
import com.okman.shop.common.exception.OkManDeniedException;
import com.okman.shop.common.model.Result;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * <p>
 *  授权拒绝处理器，覆盖默认的OAuth2AccessDeniedHandler 包装失败信息到PigDeniedException
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/12 11:32
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class OkManAccessDeniedHandler extends OAuth2AccessDeniedHandler {

    private final ObjectMapper objectMapper;

    /**
     * 授权拒绝处理，使用R包装
     * @param request request
     * @param response response
     * @param authException authException
     */
    @Override
    @SneakyThrows
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException authException) {
        log.info("授权失败，禁止访问 {}", request.getRequestURI());
        response.setCharacterEncoding(CommonConstants.UTF8);
        response.setContentType(CommonConstants.CONTENT_TYPE);
        Result<OkManDeniedException> result = Result.failed(new OkManDeniedException("授权失败，禁止访问"));
        response.setStatus(HttpStatus.HTTP_FORBIDDEN);
        PrintWriter printWriter = response.getWriter();
        printWriter.append(objectMapper.writeValueAsString(result));
    }
}
