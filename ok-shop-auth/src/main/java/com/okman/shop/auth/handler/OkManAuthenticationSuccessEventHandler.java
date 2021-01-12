package com.okman.shop.auth.handler;

import com.okman.shop.security.handler.AbstractAuthenticationSuccessEventHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
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
public class OkManAuthenticationSuccessEventHandler extends AbstractAuthenticationSuccessEventHandler {
    /**
     * 处理登录成功方法
     * <p>
     * 获取到登录的authentication 对象
     * @param authentication 登录对象
     */
    @Override
    public void handle(Authentication authentication) {
        log.info("用户：{} 登录成功", authentication.getPrincipal());
    }
}
