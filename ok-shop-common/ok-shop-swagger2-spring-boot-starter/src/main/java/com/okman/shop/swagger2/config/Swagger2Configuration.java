package com.okman.shop.swagger2.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * <p>
 *  swagger2配置类
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2020/12/30 15:24
 */
@Configuration
@ConditionalOnProperty(name = "ok.shop.swagger.enabled",matchIfMissing = true)
@Import({Swagger2Configuration.class})
public class Swagger2Configuration {

}
