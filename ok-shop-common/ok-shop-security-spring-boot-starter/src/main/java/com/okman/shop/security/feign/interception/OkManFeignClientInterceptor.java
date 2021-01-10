package com.okman.shop.security.feign.interception;

import cn.hutool.core.collection.CollUtil;
import com.okman.shop.common.constant.SysConstants;
import feign.RequestTemplate;
import org.springframework.cloud.commons.security.AccessTokenContextRelay;
import org.springframework.cloud.openfeign.security.OAuth2FeignRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;

import java.util.Collection;

/**
 * <p>
 * OkManFeignClientInterceptor
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：扩展OAuth2FeignRequestInterceptor
 * @Date 2021/1/10 13:50
 */
public class OkManFeignClientInterceptor extends OAuth2FeignRequestInterceptor {

    private final OAuth2ClientContext oAuth2ClientContext;

    private final AccessTokenContextRelay accessTokenContextRelay;

    public OkManFeignClientInterceptor(OAuth2ClientContext oAuth2ClientContext, OAuth2ProtectedResourceDetails resource, AccessTokenContextRelay accessTokenContextRelay) {
        super(oAuth2ClientContext, resource);
        this.oAuth2ClientContext = oAuth2ClientContext;
        this.accessTokenContextRelay = accessTokenContextRelay;
    }

    @Override
    public void apply(RequestTemplate template) {
        Collection<String> fromHeader = template.headers().get(SysConstants.FROM);
        if (CollUtil.isNotEmpty(fromHeader) && fromHeader.contains(SysConstants.FROM_IN)) {
            return;
        }

        accessTokenContextRelay.copyToken();
        if (oAuth2ClientContext != null && oAuth2ClientContext.getAccessToken() != null) {
            super.apply(template);
        }
    }
}
