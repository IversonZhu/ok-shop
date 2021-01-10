package com.okman.shop.security.aspect;

import cn.hutool.core.util.StrUtil;
import com.okman.shop.common.constant.SysConstants;
import com.okman.shop.security.annotation.NotAuth;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.security.access.AccessDeniedException;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 服务间接口不鉴权处理逻辑
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/10 14:06
 */
@Slf4j
@Aspect
@RequiredArgsConstructor
public class OkManSecurityInnerAspect implements Ordered {

    private final HttpServletRequest request;

    @SneakyThrows
    @Around("@annotation(notAuth)")
    public Object around(ProceedingJoinPoint point, NotAuth notAuth) {
        String header = request.getHeader(SysConstants.FROM);
        if (notAuth.value() && !StrUtil.equals(SysConstants.FROM_IN, header)) {
            log.warn("访问接口 {} 没有权限", point.getSignature().getName());
            throw new AccessDeniedException("Access is denied");
        }
        return point.proceed();
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 1;
    }
}
