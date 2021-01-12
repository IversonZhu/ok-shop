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
public class ServerErrorException extends OkManAuth2Exception {

    public ServerErrorException(String msg, Throwable t) {
        super(msg);
    }

    @Override
    public String getOAuth2ErrorCode() {
        return "server_error";
    }

    @Override
    public int getHttpErrorCode() {
        return HttpStatus.INTERNAL_SERVER_ERROR.value();
    }
}
