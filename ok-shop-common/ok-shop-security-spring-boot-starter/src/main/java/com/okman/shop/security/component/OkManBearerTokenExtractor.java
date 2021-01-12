package com.okman.shop.security.component;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.okman.shop.security.properties.PermitAllUrlProperties;

import lombok.RequiredArgsConstructor;

/**
 * <p>
 * 改造 {@link BearerTokenExtractor} 对公开权限的请求不进行校验
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：改造 {@link BearerTokenExtractor} 对公开权限的请求不进行校验
 * @Date 2021/1/12 10:44
 */

@Component
@RequiredArgsConstructor
public class OkManBearerTokenExtractor extends BearerTokenExtractor {

    private final PathMatcher pathMatcher = new AntPathMatcher();

    private final PermitAllUrlProperties urlProperties;

    @Override
    public Authentication extract(HttpServletRequest request) {
        boolean match =
            urlProperties.getUrls().stream().anyMatch(url -> pathMatcher.match(url, request.getRequestURI()));

        return match ? null : super.extract(request);
    }
}
