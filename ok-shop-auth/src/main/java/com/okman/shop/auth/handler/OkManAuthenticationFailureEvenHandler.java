package com.okman.shop.auth.handler;

import com.okman.shop.security.handler.AbstractAuthenticationFailureEvenHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/12 14:12
 */
@Slf4j
@Component
public class OkManAuthenticationFailureEvenHandler extends AbstractAuthenticationFailureEvenHandler {
    /**
     * 处理登录失败方法
     * <p>
     * @param authenticationException 登录的authentication 对象
     * @param authentication 登录的authenticationException 对象
     */
    @Override
    public void handle(AuthenticationException authenticationException, Authentication authentication) {
        log.info("用户：{} 登录失败，异常：{}", authentication.getPrincipal(), authenticationException.getLocalizedMessage());
    }
}
