package com.okman.shop.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;

/**
 * <p>
 * 认证相关配置
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：认证相关配置
 * @Date 2021/1/10 12:59
 */

@Primary
@Order(90)
@Configuration
public class WebSecurityConfig /**extends WebSecurityConfigurerAdapter */ {
}
