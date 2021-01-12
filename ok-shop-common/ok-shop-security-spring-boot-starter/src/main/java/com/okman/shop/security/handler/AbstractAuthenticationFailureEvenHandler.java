package com.okman.shop.security.handler;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * <p>
 *  认证失败事件处理器
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：认证失败事件处理器
 * @Date 2021/1/12 11:32
 */
public abstract class AbstractAuthenticationFailureEvenHandler
    implements ApplicationListener<AbstractAuthenticationFailureEvent> {

    /**
     * Handle an application event.
     * 
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(AbstractAuthenticationFailureEvent event) {
        AuthenticationException authenticationException = event.getException();
        Authentication authentication = (Authentication)event.getSource();

        handle(authenticationException, authentication);
    }

    /**
     * 处理登录成功方法
     * <p>
     * 
     * @param authenticationException 登录的authentication 对象
     * @param authentication 登录的authenticationException 对象
     */
    public abstract void handle(AuthenticationException authenticationException, Authentication authentication);

}
