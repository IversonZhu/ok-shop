package com.okman.shop.security.handler;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;

import cn.hutool.core.collection.CollUtil;

/**
 * <p>
 *  认证成功事件处理器
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：认证成功事件处理器
 * @Date 2021/1/12 11:32
 */
public abstract class AbstractAuthenticationSuccessEventHandler
		implements ApplicationListener<AuthenticationSuccessEvent> {

	/**
	 * Handle an application event.
	 * @param event the event to respond to
	 */
	@Override
	public void onApplicationEvent(AuthenticationSuccessEvent event) {
		Authentication authentication = (Authentication) event.getSource();
		if (CollUtil.isNotEmpty(authentication.getAuthorities())) {
			handle(authentication);
		}
	}

	/**
	 * 处理登录成功方法
	 * <p>
	 * 获取到登录的authentication 对象
	 * @param authentication 登录对象
	 */
	public abstract void handle(Authentication authentication);

}
