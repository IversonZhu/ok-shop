package com.okman.shop.upms.service.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * <p>
 *
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/8 17:23
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.okman.shop.upms.service.mapper")
public class MyBatisPlusConfig {}
