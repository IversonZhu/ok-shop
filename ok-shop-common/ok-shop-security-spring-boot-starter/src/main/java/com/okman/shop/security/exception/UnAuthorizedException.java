package com.okman.shop.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.okman.shop.security.component.OkManAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;

/**
 * <p>
 * ForbiddenException
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/10 13:43
 */
@JsonSerialize(using = OkManAuth2ExceptionSerializer.class)
public class UnAuthorizedException extends OkManAuth2Exception {

    public UnAuthorizedException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "unauthorized";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.UNAUTHORIZED.value();
    }
}
