package com.okman.shop.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 网关配置文件
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：网关配置文件
 * @Date 2021/1/10 14:48
 */

@Data
@Component
@RefreshScope
@ConfigurationProperties("gateway")
public class GatewayConfigProperties {

    /**
     * 网关解密登录前端密码 秘钥 {@link com.okman.shop.gateway.filter.PasswordDecoderFilter}
     */
    public String encodeKey;

    /**
     * 网关不需要校验验证码的客户端 {@link com.okman.shop.gateway.filter.ValidateCodeGatewayFilter}
     */
    public List<String> ignoreClients;
}
