package com.okman.shop.auth.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import com.okman.shop.common.constant.CacheConstants;
import com.okman.shop.common.constant.SysConstants;
import com.okman.shop.security.component.OkManWebResponseExceptionTranslator;
import com.okman.shop.security.dto.OkManUserDto;
import com.okman.shop.security.service.OkManClientDetailsService;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

/**
 * <p>
 * 认证服务器配置
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：认证服务器配置
 * @Date 2021/1/10 13:01
 */

@Configuration
@RequiredArgsConstructor
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final DataSource dataSource;

    private final UserDetailsService userDetailsService;

    private final AuthenticationManager authenticationManager;

    private final RedisConnectionFactory redisConnectionFactory;

    @Override
    @SneakyThrows
    public void configure(ClientDetailsServiceConfigurer clients) {
        OkManClientDetailsService clientDetailsService = new OkManClientDetailsService(dataSource);
        clientDetailsService.setSelectClientDetailsSql(SysConstants.DEFAULT_SELECT_STATEMENT);
        clientDetailsService.setFindClientDetailsSql(SysConstants.DEFAULT_FIND_STATEMENT);
        clients.withClientDetails(clientDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.allowFormAuthenticationForClients().checkTokenAccess("permitAll()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST).tokenStore(tokenStore())
            .tokenEnhancer(tokenEnhancer()).userDetailsService(userDetailsService)
            .authenticationManager(authenticationManager).reuseRefreshTokens(false)
            .pathMapping("/oauth/confirm_access", "/token/confirm_access")
            .exceptionTranslator(new OkManWebResponseExceptionTranslator());
    }

    @Bean
    public TokenStore tokenStore() {
        RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
        tokenStore.setPrefix(CacheConstants.PROJECT_OAUTH_ACCESS);
        return tokenStore;
    }

    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            final Map<String, Object> additionalInfo = new HashMap<>(4);
            OkManUserDto okManUserDto = (OkManUserDto)authentication.getUserAuthentication().getPrincipal();
            additionalInfo.put(SysConstants.DETAILS_LICENSE, SysConstants.PROJECT_LICENSE);
            additionalInfo.put(SysConstants.DETAILS_USER_ID, okManUserDto.getId());
            additionalInfo.put(SysConstants.DETAILS_USERNAME, okManUserDto.getUsername());
            additionalInfo.put(SysConstants.DETAILS_DEPT_ID, okManUserDto.getDeptId());
            ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(additionalInfo);
            return accessToken;
        };
    }

}
