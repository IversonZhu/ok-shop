package com.okman.shop.security.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.okman.shop.common.util.WebUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;


import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 *  表单登录失败处理逻辑
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：认证成功事件处理器
 * @Date 2021/1/12 11:32
 */
@Slf4j
public class FormAuthenticationFailureHandler implements AuthenticationFailureHandler {

	/**
	 * Called when an authentication attempt fails.
	 * @param request the request during which the authentication attempt occurred.
	 * @param response the response.
	 * @param exception the exception which was thrown to reject the authentication
	 */
	@Override
	@SneakyThrows
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) {
		log.debug("表单登录失败:{}", exception.getLocalizedMessage());
		String url = HttpUtil.encodeParams(String.format("/token/login?error=%s", exception.getMessage()),
				CharsetUtil.CHARSET_UTF_8);
		WebUtils.getResponse().sendRedirect(url);
	}

}
